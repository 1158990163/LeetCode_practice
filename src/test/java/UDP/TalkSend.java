package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {
    DatagramSocket socket = null;
    BufferedReader br = null;

    private int fromport;
    private String to_IP;
    private int toport;

    public TalkSend() {
    }

    public TalkSend(int fromport, String to_IP, int toport) {
        this.fromport = fromport;
        this.to_IP = to_IP;
        this.toport = toport;

        try {
            socket = new DatagramSocket(fromport);
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                String str = br.readLine();
                byte[] bts = str.getBytes();
                DatagramPacket packet = new DatagramPacket(bts, 0, bts.length, new InetSocketAddress(to_IP, toport));

                socket.send(packet);
                if ("bye".equals(str)) {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
