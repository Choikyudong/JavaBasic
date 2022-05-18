package java_forChap.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UdpServer와 통신한다.
 */
public class UdpUser {

    public static void mainMethd() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getLocalHost();

        // 데이터 전송용 저장공간
        byte[] msg = new byte[100];

        DatagramPacket outPacket = new DatagramPacket(msg, 1, inetAddress, 12345);
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        // send와 receive로 통신을 한다.
        datagramSocket.send(outPacket);
        datagramSocket.receive(inPacket);

        System.out.println("받은 값 : " + new String(inPacket.getData()));
    }

    public static void main(String[] args) {
        try {
            mainMethd();
        } catch (Exception e) {
            System.out.println("고객 문제 발생");
        }
    }

}
