package thread;

/**
 * 安全地终止线程
 * 中断操作是一种简便的线程间交互方式，这种交互方式最适合用来取消或停止任务。
 * 除了中断以外，还可以利用一个boolean变量来控制是否需要停止任务并终止该线程
 * 这种通过标识位或者中断操作的方式能够使线程在终止时有机会去清理资源
 * Created by xuzixu on 2019/1/16.
 */
public class Shutdown {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runner());
        Runner runner = new Runner();
        Thread thread1 = new Thread(runner);
        thread.start();
        thread1.start();
        SleepUtils.second(2);
        thread.interrupt();
        runner.cancel();
    }

    static class Runner implements Runnable {
        private int i;
        private boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count: " + i);
        }

        private void cancel() {
            on = false;
        }
    }
}
