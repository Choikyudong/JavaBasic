package level_03.java_chap02;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * 자바로 하는 네트워킹
 * 세상에 많은 컴퓨터 언어가 존재하지만
 * 그중에서 특히 자바는 웹프로그맹의 서버역할로써 많이 사용이 된다.
 * 요즘에 Node.js 또는 파이썬으로도 구축을 많이 하지만
 * 아직까지는 자바가 많이 사용된다는 사실은 부정하기는 어렵다.
 *
 * 여기서는 자바에서 기본적으로 제공이 되는키지로
 * 네트워킹을 간단하게 학습한다. 자세한 네트워킹은 지식 java.net 패들은 알아서 찾아봐야한다.
 *
 * 네트워킹이란 두 대 이상의 컴퓨터를 연결하여 네트워크를 구성하는 것이다.
 */
public class Chap_01 {

    /** 
     * 우선 간단한 용어에 대해서 정리를 하고가면 편하다
     * 서버 : 서비스를 제공하는 컴퓨터
     * 클라이언트 : 서비스를 사용하는 컴퓨터이다.
     * 
     * 서버라고 꼭 특별한 장치나 이런것이 아니다.
     * 현재 해당 클래스를 입력하는 노트북이 서버가 될 수 있다.
     * 자바로 만들어진 WAS(웹 애플리케이션 서버)인 Tomcat으로
     * 해당 피시를 서버역할로 수행을 시킬 수 있다.
     *
     * 즉 서버라는것은 특별한 하드웨어만이 가능한 것이 아니다.
     */
    public static void main(String[] args) {
        /**
         * 우선 간단하게 IP 주소에 대해서 알아보고 넘어가야한다.
         * Ip 주소는 네트워크 즉 인터넷에 연결된 모든 컴퓨터가 가지고 있다.
         *
         * IP 주소는 4byte(32bit) 정수로 구성되어 있으며
         * 4개의 정수가 마침표를 구분자로 사용하여 표기된다.
         * 예시) 242.125.231.142
         * 그리고 각 영역의 값들은 0~255 즉 1byte 크기 만큼 가진다.
         *
         * 여기서 더 파고들면 IP 주소의 클래스의 개념이 있는데 그건 구글에 검색
         *
         * 참고로 윈도우 기준으로 자신의 Ip를 확인할려면
         * CMD 또는 PowerShell에 ipconfig 명령어를 입력하면 된다.
         * 그리고 Ip
         */

        // 자바에서 기본적으로 IP 주소를 다루기 위한 클래스이다.
        InetAddress inetAddress = null;

        // 기본적으로해당 클래스를 다루기 위해서는 exception을 잡아줘야 한다.
        try {
            // getByName()을 통해서 원하는 도메인의 값을 가져온다. http는 안붙여도 된다.
            inetAddress = InetAddress.getByName("www.google.com");
            System.out.println("Address : " + inetAddress.getHostAddress());
            System.out.println("Address(byte[]) : " + Arrays.toString(inetAddress.getAddress()));
            System.out.println("HostName : " + inetAddress.getHostName());
        } catch (UnknownHostException | UnknownError error) {
            System.out.println("구글이 망했나?");
        } finally {
            System.out.println("\n한박자 쉬고\n");
        }

        try {
            // getLocalHost()로 로컬주소를 가져올 수 있다.
            inetAddress = InetAddress.getLocalHost();
            System.out.println("Address : " + inetAddress.getHostAddress());
            System.out.println("Address(byte[]) : " + Arrays.toString(inetAddress.getAddress()));
            System.out.println("HostName : " + inetAddress.getHostName());
        } catch (Exception e) {
            System.out.println("이건 무슨?");
        }

        /**
         * URL(Uniform Resource Locator)
         * 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소이다. 기본적인 구성은 아래와 같다.
         * 프로토콜://도메인:포트번호/경로명/파일명?쿼리스트링#참조
         *
         * https 와 http는 각각 443, 80을 포트값으로 가진다. 그리고 2개의 포트값은 인터넷에서
         * 약속으로써 사용되는 포트로써 URL에서는 자동으로 감춰준다.
         *
         * 그리고 자바에서는 이런 URL을 다루기 위해서 기본적으로 클래스가 제공된다.
         */
        // 해당 클래스로 이용이 가능하다.
        URL url;

        // url을 가져오는 방법은 여러가지 방법이 있다.
        try {
            // 프로토콜부터 도메인 포트 파일까지 세세하게 입력하는 방법
            url = new URL("http","www.google.com", 80, "/search?q=Hello+World");
            // 특정주소를 바로 가져오는 방법
            url = new URL("https://www.google.com/search?q=Hello+World");

            System.out.println("권한 : " + url.getAuthority());
            System.out.println("경로명 : " + url.getPath());
            System.out.println("프토토콜 : " + url.getProtocol());
            System.out.println("포트 : " + url.getPort());

            // String 값으로
            String s1 = url.toExternalForm();
            // 근데 이거랑 무슨 차이일까여?
            String s2 = url.toString();

            // 같은 url인지 판단한다.
            System.out.println(url.sameFile(url));

            // 해당 클래스는 URL과 연동을 하기위한 용도로 뒤에 기술할 예정
            URLConnection urlConnection = url.openConnection();

            // URI로 변경을 해주는 메서드
            URI uri = url.toURI();

        } catch (IOException | URISyntaxException e) {
            System.out.println("이름이 신기한 예외");
        }

        /**
         * URI와 URL 그리고 URN
         * 우선 결론부터 말하면 URL과 URN은 URI에 포함된 개념이다.
         * URI : 인터넷의 위치 또는 자원을 유일하게 나타내는 주소이다.
         * URL : 인터넷에서 자원의 위치가 어디있는지 알려주는 규약
         * URN : 자원의 이름을 나타내는데 사용한다.
         *
         * |----------------URL---------------|
         * https://www.naver.com/file/download?folder=my+Folder
         *        |----------------------URN------------------|
         * |-----------------------URI------------------------|
         *
         */
    }

}
