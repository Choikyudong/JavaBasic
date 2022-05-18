package level_03.java_chap02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 자바로 하는 소켓통신
 * 소켓이란 프로세스간 통신에 사용되는 양쪽 끝단(endpoint)를 의미한다.
 * 쉽게 말하자면 섬과 섬을 연결하는 "다리"의 역할을 한다고 생각하자.
 * 네트워킹을 통하여 송수신을 하고싶다면 소켓을 거쳐서 해야한다.
 *
 * 소켓은 5-Tuple 이라는 규격에 맞추어 진행이 된다.
 *
 * 5-Tuple
 * 1. 프로토콜(TCP, UDP)
 * 2. 자신의 IP
 * 3. 자신의 Port
 * 4. 상대방의 IP
 * 5. 상대방의 Port
 *
 * endpoint
 * www.domain.com/user_profile/user : 여기서 endpoint는 /user_profile/user가 된다.
 */
public class Chap_03 {

    /** 
     * 소켓 통신을 하기전에 TCP, UDP의 개념을 짧게 정리를 하면
     * TCP : 연결 후 통신, 1:1 방식, 신뢰성, 상대적 느림
     * UDP : 연결없이 통신, 1:n, 1:1 등 다양한 방식,신뢰성없음, 상대적 빠름
     *
     * 많은 예시로 TCP는 전화를 UDP는 소포에 비유를 한다고 한다.
     */
    public static void main(String[] args) {
        /**
         * 먼저 TCP를 먼저 다뤄본다.
         * 앞에서 길게 설명한것처럼 TCP는 소켓을 이용한 통신을 한다.
         *
         * 통신을 시작할 때 서버소켓이 포트를 통해서 사용자의 연결요청을
         * 받고 소켓을 생성하여 상대편 소켓과 통신을 하도록 한다.
         * 즉 서버소켓이 직접적으로 통신을 하는것이 아니라 서버소켓에
         * 의해서 생성된 소켓이 직접적인 통신을 담당한다.
         *
         * 코드(?)적으로 이야기하자면 소켓(서버소켓 X)에 의해서 생성된
         * 소켓들의 입력스트림을 통해서 통신이 된다는 말이다.
         */

        // 실질적인 프로세스간의 통신을 담당하는 역할, input & outputStream 으로 통신한다.
        Socket socket;

        // 포트와 연결(bind)되어 외부의 요청이 들어오면 위의 Socket을 생성하여 소켓들끼리 통신하도록 한다.
        // 중요한점은 한 포트에 하나의 서버소켓만을 다뤄야한다.
        ServerSocket serverSocket;

        /**
         * UDP는 TCP와 다르게  연결지향이지는 않다.
         * 연결보다는 속도에 중점을 맞춘 방식이다.
         */

        DatagramSocket datagramSocket;
        DatagramPacket datagramPacket;
        /**
         * TCP와 달리 UDP는 연결에 큰 의미를 갖지는 않는다. 그래서 ServerSocket이 없다.
         * datagramSocke으로 연결하고 datagramPacket에 데이터를 담아서 전송한다.
         *
         * 정리하면 datagramPacket에 데이터를 담아서 상대방의 datagramSocket에 전달한다.
         */

         //자세한건 java_forChap 패키지에 있음

    }

}
