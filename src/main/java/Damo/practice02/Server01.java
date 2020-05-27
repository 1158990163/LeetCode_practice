package Damo.practice02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server01 {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket(9999);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        ms.joinGroup(InetAddress.getByName("224.0.1.0"));

        ms.receive(dp);

        int length = dp.getLength();
        System.out.println(new String(bytes, 0, length));
        ms.close();
    }
}
