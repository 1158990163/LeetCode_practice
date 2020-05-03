package UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {

    DatagramSocket datagramSocket = null;
    private int port;
    private String name;

    public TalkReceive(int port, String name) {
        this.port = port;
        this.name = name;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] bts = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bts, 0, bts.length);
            try {
                datagramSocket.receive(datagramPacket);

                byte[] data = datagramPacket.getData();
                String recieveData = new String(data, 0, data.length);
                System.out.println(name + ": " + recieveData);

                if ("bye".equals(recieveData)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}
