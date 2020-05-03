package NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


public class Selector_demo {
    @Test
    public void client() {
        SocketChannel sc = null;
        try {
            //获取通道
            sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
            //切换非阻塞
            sc.configureBlocking(false);
            //分配缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            Scanner scan = new Scanner(System.in);
            //发送数据给服务器；
            while (scan.hasNext()) {
                String s = scan.nextLine();
                buf.put(s.getBytes());
                buf.flip();
                sc.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void Server() {

        try {
            //获取通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            //切换非阻塞
            ssc.configureBlocking(false);
            //绑定连接
            ssc.bind(new InetSocketAddress(9898));
            //获取选择器
            Selector selector = Selector.open();
            //将通道注册到改选择器上,并指定监听事件
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("==========================");
            //轮询选择器上准备就绪的事件
            while (selector.select() > 0) {
                //遍历选择器上准备好了的选择键（已经就绪的监听事件）
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //如果该选择键表示“接受就绪”事件
                    if (key.isAcceptable()) {
                        //获取客户端连接
                        SocketChannel sChannel = ssc.accept();
                        //切换到非阻塞
                        sChannel.configureBlocking(false);
                        //将通道注册到选择器上，并指定监听的事件是（读取就绪）
                        sChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("连接成功");
                    } else if (key.isReadable()) {     ////如果该选择键表示“读取就绪”事件
                        System.out.println("连接=======》");
                        //获取该选择器上的通道
                        SocketChannel channel = (SocketChannel) key.channel();
                        //读取数据
                        ByteBuffer bbf = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = channel.read(bbf)) > 0) {
                            bbf.flip();
                            System.out.println(new String(bbf.array(), 0, len));
                            System.out.println("读取成功");
                            bbf.clear();
                        }
                    }
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
