package java_forChap.tcp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            String localhost = "127.0.0.1";
            Socket socket = new Socket(localhost, 62456);

            System.out.println("서버에 접속했습니다.");
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            System.out.println("연결문제");
        } catch (IOException io) {
            System.out.println("io 문제");
        } catch (Exception e) {
            System.out.println("뭐임?");
        }
    }

}
