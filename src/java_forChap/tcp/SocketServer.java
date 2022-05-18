package java_forChap.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 소켓 통신을 위한 서버 역할
 */
public class SocketServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(65000);) {
            System.out.println("Socket Server Running!");

            // 30초간 요청이 없다면 소켓통신을 해제한다.
            serverSocket.setSoTimeout(30 * 1000);

            Socket socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (IOException io) {
            System.out.println("Failed to start server by i dont know");
        }

    }
    
}

class Sender extends Thread {

    Socket socket;
    DataOutputStream dataOutputStream;

    Sender(Socket socket) {
        this.socket = socket;
        try {
            dataOutputStream  = new DataOutputStream(socket.getOutputStream());
        } catch (IOException io) {
            System.out.println("소켓 실행 실패");
        }
    }

    // 쓰레드를 실행시키기 위해서는 run()을 구현해야한다.
    @Override
    public void run() {
        String msg = "Hello";
        while (dataOutputStream != null) {
            try {
                System.out.println("하고싶은말을 입력하세요");
                dataOutputStream.writeUTF(msg);
            } catch (IOException io) {
                System.out.println("스트림 에러");
            }
        }
    }
}

class Receiver extends Thread {

    Socket socket;
    DataInputStream dataInputStream;

    Receiver(Socket socket) {
        this.socket = socket;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException io) {
            System.out.println("소켓 실행 실패");
        }
    }

    // 쓰레드를 실행시키기 위해서는 run()을 구현해야한다.
    @Override
    public void run() {
        while (dataInputStream != null) {
            try {
                System.out.println(dataInputStream.readUTF());;
            } catch (IOException io) {
                System.out.println("스트림 에러");
            }
        }
    }
}