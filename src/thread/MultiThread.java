package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 查看一个普通的Java程序包含哪些线程
 * Created by xuzixu on 2019/1/15.
 */
public class MultiThread {
    public static void main(String[] args){
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo:threadInfos){
            System.out.println("threadId:"+threadInfo.getThreadId()+" threadName:"+threadInfo.getThreadName());
        }
    }
}
