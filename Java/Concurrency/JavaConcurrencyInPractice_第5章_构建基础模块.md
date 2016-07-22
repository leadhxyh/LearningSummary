- ### 同步容器类：
包括Vector、Hashtable和Collections.synchronizedXxx返回的封装类。同步容器类都是线程安全的，但在某些情况下需要额外的客户端加锁来保护符号操作。例子：
```
public class UnsafeVectorHelpers {
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
```
如果线程A在10个元素的vector上调用getLast，线程B调用deleteLast可能会出现越界。

- ### 并发容器:
ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue

- ConcurrentHashMap：采用分段锁机制，允许任意数量的读取线程并发访问，一定数量的写入线程并发访问。

- 阻塞队列：简化了生产者消费者模式。例子：
```
占位
```

- ### 同步工具类：
闭锁（CountDownLatch）、FutureTask、信号量(Semaphore)、CyclicBarrier

- CountDownLatch：延迟线程的进度，确保某些活动在其他活动都完成后才继续执行。例子：
```
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        //其他线程在主线程执行到这里是都将阻塞
        startGate.countDown();
        //主线程阻塞直到endGate变为0
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
```

- FutureTask：获取在另一个线程计算的结果。
```
public class Preloader {
    ProductInfo loadProductInfo() throws DataLoadException {
        return null;
    }

    private final FutureTask<ProductInfo> future =
        new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
            public ProductInfo call() throws DataLoadException {
                return loadProductInfo();
            }
        });
    private final Thread thread = new Thread(future);

    public void start() { thread.start(); }

    public ProductInfo get()
            throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException)
                throw (DataLoadException) cause;
            else
                throw LaunderThrowable.launderThrowable(cause);
        }
    }

    interface ProductInfo {
    }
}
```

- Semaphare：信号量，一种简化的形式互斥量。具备不可重入的加锁语意。列子
```
public class BoundedHashSet <T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded)
                sem.release();
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            sem.release();
        return wasRemoved;
    }
}
```
该例子使用信号量实现一个有界的集合，添加元素时信号量加1，移除时信号量减1.

- CyclicBarrier：当线程到达栅栏调用await方法，这个方法将阻塞直到所有线程到达该栅栏栅栏被打开，所有线程被释放，栅栏被重置。

- ### 构建高效的结果缓存
1、使用HashMap和同步机制
```
public class Memoizer1 <A, V> implements Computable<A, V> {
    @GuardedBy("this") private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
    	//获取缓存
        V result = cache.get(arg);
        //不在缓存则重写计算，加入缓存
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
interface Computable <A, V> {
    V compute(A arg) throws InterruptedException;
}
class ExpensiveFunction
        implements Computable<String, BigInteger> {
    public BigInteger compute(String arg) {
        // after deep thought...
        return new BigInteger(arg);
    }
}```
2、使用ConcurrentHashMap
```
public class Memoizer2 <A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
```
这种方法有一个问题：当某个线程启动了一个开销很大的计算，正在执行，另一个线程并不知道，可能重复计算。
3.使用FutureTask
```
public class Memoizer2 <A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
```



