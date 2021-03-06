1.	减小锁的竞争
	-	缩短锁持有的时间：将不需要同步的代码移除同步块
	- 	降低请求频率：锁分段技术。例如，ConcurrentHashMap使用一个包含16个锁的数组，每个锁保护所有桶的1/16，第N个桶由第(N mod 16)来保护。
   -	读写锁(ReadWriteLock)：有多个读取操作时可以共享资源，当有写入操作时将独占锁。
2.	减少上下文切换
发生阻塞的一个原因是产生各种日志，给出一个优化的日志框架(P124)来分析如何减少上下文切换。
```
public class LogWriter {
    private final BlockingQueue<String> queue;
    private final LoggerThread logger;
    private static final int CAPACITY = 1000;

    public LogWriter(Writer writer) {
        this.queue = new LinkedBlockingQueue<String>(CAPACITY);
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(Writer writer) {
            this.writer = new PrintWriter(writer, true); // autoflush
        }

        public void run() {
            try {
                while (true)
                    writer.println(queue.take());
            } catch (InterruptedException ignored) {
            } finally {
                writer.close();
            }
        }
    }
}
```
该例子基于生产者消费者模式，在一个单独的线程中打印日志（会阻塞），从而减少工作线程阻塞的次数，提高了并发性。