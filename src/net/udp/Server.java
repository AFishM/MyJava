package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by xuzixu on 2019/7/11.
 */
public class Server {
    public static void main(String[] args){
        byte[] buffer=new byte[1024];
        try {
            DatagramSocket socket=new DatagramSocket(3000);
            DatagramPacket receive=new DatagramPacket(buffer,1024);
            System.out.println("server is waiting");
            while (true){
                try {
                    socket.receive(receive);
                    System.out.println("receive:"+new String(receive.getData()));
                    InetAddress address=receive.getAddress();
                    int port=receive.getPort();
                    System.out.println("from:"+address.getHostAddress()+":"+port);
                    String response="copy";
                    DatagramPacket send=new DatagramPacket(response.getBytes(),response.length(),address,port);
                    socket.send(send);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
