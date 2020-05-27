package Damo.practice01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(9999);

        while (true){
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
            ds.receive(dp);
            String s = new String(bytes, 0, dp.getLength());
            System.out.println(s);
            if ("886".equals(s))break;
        }
    }
}
