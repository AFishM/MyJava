package thread;

import java.util.concurrent.TimeUnit;

/**
 * 查看示例代码运行时的线程信息，更加深入地理解线程状态
 * 打开终端键入“jps”可以看到运行示例对应的进程ID
 * 再键入“jstack 进程id”可以看到线程状态
 * Created by xuzixu on 2019/1/16.
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), TimeWaiting.class.getSimpleName()).start();
        new Thread(new Waiting(), Waiting.class.getSimpleName()).start();
        new Thread(new Blocked(), Blocked.class.getSimpleName()).start();
        new Thread(new Blocked(), Blocked.class.getSimpleName()).start();
    }

    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
