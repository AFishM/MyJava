package thread.interthreadcommunication;

/**
 * 通过使用javap工具查看生成的class文件信息来分析synchronized关键字的实现细节
 * 在Synchronized.class同级目录执行javap –v Synchronized.class
 *
 * 同步块的实现使用了monitorenter和monitorexit指令，而同步方法则是依靠方法修饰符上的ACC_SYNCHRONIZED来完成的。
 * 无论采用哪种方式，其本质是对一个对象的监视器（monitor）进行获取
 * 而这个获取过程是排他的，也就是同一时刻只能有一个线程获取到由synchronized所保护对象的监视器
 * Created by xuzixu on 2019/1/17.
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {//对SynchronizedClass对象进行加锁
        }
        m();// 静态同步方法，对Synchronized Class对象进行加锁
    }

    private static synchronized void m() {
    }
}
