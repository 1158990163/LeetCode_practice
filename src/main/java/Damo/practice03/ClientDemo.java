package Damo.practice03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("127.0.0.1",9999);

        OutputStream os = soc.getOutputStream();

        os.write("伟大大王".getBytes());

        os.close();
        soc.close();

    }
}
