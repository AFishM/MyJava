package thread;

/**
 * 三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC
 * Created by xuzixu on 2019/1/10.
 */
public class LogABCBy3ThreadByTurns extends Thread {
    private final Object prev;
    private final Object self;//self可以用this替代，所以下面的byte数组也是可以省略的

    private LogABCBy3ThreadByTurns(String name, Object prev, Object self) {
        super(name);
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        super.run();
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(getName());
                    count--;
                    self.notify();
                }
                if (count > 0) {
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + " " + currentThread.getId());

        byte[] a = new byte[0];//据说，零长度的byte数组对象创建起来将比任何对象都经济
        byte[] b = new byte[0];//查看编译后的字节码：生成零长度的byte[]对象只需3条操作码
        byte[] c = new byte[0];//而Object lock = new Object()则需要7行操作码
        LogABCBy3ThreadByTurns threadA = new LogABCBy3ThreadByTurns("A", c, a);
        LogABCBy3ThreadByTurns threadB = new LogABCBy3ThreadByTurns("B", a, b);
        LogABCBy3ThreadByTurns threadC = new LogABCBy3ThreadByTurns("C", b, c);
        try {
            threadA.start();
            sleep(50);
            threadB.start();
            sleep(50);
            threadC.start();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(currentThread.getName() + " " + currentThread.getId());
    }
}
