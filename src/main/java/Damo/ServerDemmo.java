package Damo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemmo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=  new DatagramSocket(9999);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        ds.receive(dp);

        byte[] data = dp.getData();
        System.out.println(new String(data));

        ds.close();
    }
}
