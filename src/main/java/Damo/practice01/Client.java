package Damo.practice01;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//客户端
//无休止的可以发送数据，直到886；
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner s = new Scanner(System.in);
        while (true){
            String s1 = s.nextLine();
            byte[] bytes = s1.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,9999);
            ds.send(dp);
            if ("886".equals(s1))break;
        }
        ds.close();
    }
}
