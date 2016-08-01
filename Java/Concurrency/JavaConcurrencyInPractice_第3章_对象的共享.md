- 可见性
一个线程修改了堆中的值，可能修改的结果被保存在缓存没有刷新到主存，当另一个线程获取该值时可能看到的不是最新值。
```
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
```

- volatile变量
一种较弱的同步机制，确保修改变量不会被缓存，读取时总会返回最新写入的值。

- 线程封闭-栈封闭
将成员变量封闭在方法中，不要将其溢出。

- 线程封闭-ThreadLocal类
提供get和set接口，每个线程都保存一份独立的副本。

- 不可变对象
某个变量的状态在创建后不可修改了，称为不可变对象。不可变对象是线程安全的。