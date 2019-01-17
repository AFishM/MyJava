package thread.base;

/**
 * 观察线程的中断标识位
 * 中断可以理解为线程的一个标识位属性，线程通过检查自身是否被中断来进行响应
 *
 * 许多声明抛出InterruptedException的方法（例如Thread.sleep(long millis)方法）
 * 这些方法在抛出InterruptedException之前，Java虚拟机会先将该线程的中断标识位清除，然后抛出InterruptedException，
 * 此时调用isInterrupted()方法将会返回false
 * Created by xuzixu on 2019/1/16.
 */
public class Interrupted {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner());
        Thread runThread = new Thread(new Runner());
        sleepThread.setDaemon(true);//setDaemon是为了main运行完后没有非daemon线程，程序退出
        runThread.setDaemon(true);
        sleepThread.start();
        runThread.start();
        SleepUtils.second(5);
        sleepThread.interrupt();
        runThread.interrupt();
        System.out.println(SleepRunner.class.getName() + " " + sleepThread.isInterrupted());
        System.out.println(Runner.class.getName() + " " + runThread.isInterrupted());
        SleepUtils.second(5);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
