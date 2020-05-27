package Damo.practice02;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String s = "瓦洛兰特缝合怪必凉";
        byte[] bytes = s.getBytes();
//        组播地址
        InetAddress add = InetAddress.getByName("224.0.1.0");
        int port = 9999;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,add,port);

        ds.send(dp);

        ds.close();
    }
}
