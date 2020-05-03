package UDP;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(9898,"localhost",8989)).start();
        new Thread(new TalkReceive(8888,"学生")).start();


    }
}
