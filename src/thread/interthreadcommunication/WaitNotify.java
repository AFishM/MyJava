package thread.interthreadcommunication;

import thread.base.SleepUtils;

/**
 * 等待/通知机制
 * 使用wait()、notify()和notifyAll()时需要先对调用对象加锁
 * <p>
 * notify()或notifyAll()方法调用后，等待线程依旧不会从wait()返回，
 * 需要调用notify()或notifAll()的线程释放锁之后，等待线程才有机会从wait()返回
 * <p>
 * 等待/通知机制依托于同步机制，其目的就是确保等待线程从wait()方法返回时能够感知到通知线程对变量做出的修改
 * <p>
 * Created by xuzixu on 2019/1/18.
 */
public class WaitNotify {
    private static boolean flag = true;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Wait(), "waitThread").start();
        SleepUtils.second(5);
        new Thread(new Notify(), "notifyThread").start();
    }

    /**
     * 等待方遵循如下原则
     * 1）获取对象的锁
     * 2）如果条件不满足，那么调用对象的wait()方法，被通知后仍要检查条件
     * 3）条件满足则执行对应的逻辑
     */
    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":flag is true,wait");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":flag is false,running");
            }
        }
    }

    /**
     * 等待方遵循如下原则
     * 1）获取对象的锁
     * 2）如果条件不满足，那么调用对象的wait()方法，被通知后仍要检查条件
     * 3）条件满足则执行对应的逻辑
     */
    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ":hold lock");
                flag = false;
                lock.notify();
            }
            SleepUtils.second(5);
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ":hold lock again");
            }
        }
    }
}
