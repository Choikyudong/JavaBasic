package java_forChap.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * UdpUser와 통신한다.
 */
public class UdpServer {

    public static void mainMethod() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(12345);
        DatagramPacket inPacket, outPacket;

        byte[] getMsg = new byte[100];
        byte[] setMsg;

        while (true) {
            // 데이터 수신용 패킷설정
            inPacket = new DatagramPacket(getMsg, getMsg.length);

            // 위의 패킷을 이용해서 수신한다.
            datagramSocket.receive(inPacket);

            // 패킷에서 발신자의 정보를 가져온다.
            InetAddress inetAddress = inPacket.getAddress();
            int port = inPacket.getPort();

            // 발송할 데이터를 준비한다.
            String msg = "Hello World";
            setMsg = msg.getBytes(StandardCharsets.UTF_8);

            // 발신자의 정보를 이용해서 패킷을 꾸린다음 데이터를 전송한다.
            outPacket = new DatagramPacket(setMsg, setMsg.length, inetAddress, port);
            datagramSocket.send(outPacket);
        }
    }

    public static void main(String[] args) {
        try {
            mainMethod();
        } catch (Exception e) {
            System.out.println("서버 문제 발생");
        }
    }

}
