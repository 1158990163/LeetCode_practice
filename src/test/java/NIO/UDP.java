package NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Scanner;

public class UDP {
    @Test
    public void send() {

        try {
            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                byteBuffer.put(s.getBytes());
                byteBuffer.flip();
                dc.send(byteBuffer, new InetSocketAddress("127.0.0.1", 9898));
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void receive() {
        DatagramChannel dc = null;
        try {
            dc = DatagramChannel.open();
            dc.configureBlocking(false);
            dc.bind(new InetSocketAddress(9898));
            Selector selector = Selector.open();
            dc.register(selector, SelectionKey.OP_READ);
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    if (next.isReadable()) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        dc.receive(byteBuffer);
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
                        byteBuffer.clear();
                    }
                }
                iterator.remove();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
