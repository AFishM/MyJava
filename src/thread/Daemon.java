package thread;

import java.util.concurrent.TimeUnit;

/**
 * Daemon线程是一种支持型线程，因为它主要被用作程序中后台调度以及支持性工作
 * 一个Java虚拟机中不存在非Daemon线程的时候，Java虚拟机将会退出
 * Java虚拟机退出时Daemon线程中的finally块并不一定会执行
 * Created by xuzixu on 2019/1/16.
 */
public class Daemon {
    public static void main(String[] args){
        Thread thread=new Thread(new DaemonRunner());
        thread.setDaemon(true);
        thread.start();
    }
    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("DaemonRunner finally run");
            }
        }
    }
}
