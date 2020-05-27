package Damo.practice03;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        byte[] bytes = new byte[1024];

        while (inputStream.read(bytes)!=-1){
            System.out.println(new String(bytes,0,1024));
        }
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
