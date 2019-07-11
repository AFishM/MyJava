package net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by xuzixu on 2019/7/11.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8081);
            socket.setSoTimeout(10000);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean flag = true;
            while (flag) {
                System.out.println("请输入信息：");
                String request = input.readLine();
                out.println(request);
                if ("bye".equals(request)) {
                    flag = false;
                } else {
                    String response = in.readLine();
                    System.out.println(response);
                }
            }
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
