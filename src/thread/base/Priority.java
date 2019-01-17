package thread.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 不同的JVM以及操作系统上，线程规划会存在差异，有些操作系统甚至会忽略对线程优先级的设定
 * (预期：优先级1和优先级10的Job计数的结果非常相近，没有明显差距。表示程序正确性不能依赖线程的优先级高低)
 * (不过实验结果两者相差还是有点多的)
 * Created by xuzixu on 2019/1/15.
 */
public class Priority {
    static volatile boolean notStart = true;
    static volatile boolean notEnd = true;

    public static void main(String[] args) {
        List<Job> jobList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobList.add(job);
            Thread thread = new Thread(job);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notEnd = false;
        for (Job job : jobList) {
            System.out.println("priority: " + job.priority + " count: " + job.count);
        }
    }

    private static class Job implements Runnable {
        private int priority;
        private int count;

        Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                count++;
                Thread.yield();
            }
        }
    }
}
