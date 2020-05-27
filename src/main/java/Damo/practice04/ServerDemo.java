package Damo.practice04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        FileOutputStream fos = new FileOutputStream("src/main/resources/002.jpg");

        byte[] bytes = new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        fos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
