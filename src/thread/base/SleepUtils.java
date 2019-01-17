package thread.base;

import java.util.concurrent.TimeUnit;

/**
 * 线程休眠工具
 * Created by xuzixu on 2019/1/16.
 */
public class SleepUtils {
    public static void second(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
