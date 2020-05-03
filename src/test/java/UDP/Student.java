package UDP;

public class Student {
    public static void main(String[] args) {
        new Thread(new TalkSend(9897,"localhost",8888)).start();
        new Thread(new TalkReceive(8989,"老师")).start();
    }
}
