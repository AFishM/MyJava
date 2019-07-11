package net.udp;

import java.io.IOException;
import java.net.*;

/**
 * Created by xuzixu on 2019/7/11.
 */
public class Client {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9000);
            InetAddress address = InetAddress.getLocalHost();
            String s = "lalala";
            DatagramPacket send = new DatagramPacket(s.getBytes(), s.length(), address, 3000);
            DatagramPacket receive = new DatagramPacket(bytes, 1024);
            socket.setSoTimeout(10000);
            int retryTime = 0;
            boolean receiveResponse = false;
            while (!receiveResponse && retryTime < 5) {
                try {
                    socket.send(send);
                    socket.receive(receive);
                    if (!receive.getAddress().equals(address)) {
                        throw new IOException("receive packet from unknown host source");

                    }
                    receiveResponse = true;
                } catch (IOException e) {
                    e.printStackTrace();
                    retryTime++;
                    System.out.println("time out,retryTime:" + retryTime);
                }
            }
            if (receiveResponse) {
                System.out.println("receive:" + new String(receive.getData()));
                System.out.println("from:" + receive.getAddress().getHostAddress());
            } else {
                System.out.println("give up");
            }
            socket.close();
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
