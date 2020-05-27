package Damo;

import java.io.IOException;
import java.net.*;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        //  1
        DatagramSocket ds=  new DatagramSocket();

        //  2
        String s = "瓦洛兰特缝合怪必凉";
        byte[] bytes = s.getBytes();
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        int port = 9999;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,byName,port);

        //  3
        ds.send(dp);

        //  4

        ds.close();
    }
}
