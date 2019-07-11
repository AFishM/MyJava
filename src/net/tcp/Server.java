package net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xuzixu on 2019/7/11.
 */
public class Server {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket=new ServerSocket(8081);
            while (true){
                Socket client=serverSocket.accept();
                System.out.println("客户端连接成功");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                            PrintStream out=new PrintStream(client.getOutputStream());
                            boolean flag=true;
                            while (flag){
                                String request=in.readLine();
                                System.out.println(request);
                                if("bye".equals(request)){
                                    flag=false;
                                }else{
                                    String response="copy:"+request;
                                    out.println(response);
                                }
                            }
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
