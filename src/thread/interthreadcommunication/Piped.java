package thread.interthreadcommunication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入/输出流
 * 管道输入/输出流和普通的文件输入/输出流或者网络输入/输出流不同，
 * 它主要用于线程之间的数据传输，而传输的媒介为内存
 * Created by xuzixu on 2019/1/18.
 */
public class Piped {
    public static void main(String[] args) {
        PipedWriter out = new PipedWriter();
        try {
            PipedReader in = new PipedReader(out);
            new Thread(new Print(in), "PrintThread").start();
            int receive;
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
