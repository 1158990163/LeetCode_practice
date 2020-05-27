package Damo.practice04;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);

        FileInputStream fis = new FileInputStream("src/main/resources/123.jpg");

        byte[] bytes = new byte[1024];
        int len=0;
        while ((len =fis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }

        fis.close();
        bos.close();
        outputStream.close();
        socket.close();
    }
}
