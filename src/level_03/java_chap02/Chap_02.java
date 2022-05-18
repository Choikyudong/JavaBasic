package level_03.java_chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 자바 네트워킹2
 */
public class Chap_02 {

    public static void main(String[] args) {
        URLConnection urlConnection;
        /**
         * 어플리케이션(자바 즉 서버)과 URL간의 통신연결을 해주는
         * 클래스의 최상위 추상 클래스이다.
         *
         * 해당 클래스를 상속받아서 구현되는 클래스는
         * HttpURLConnection과 JarURLConnection이 있다.
         *
         * 이름부터가 URL을 연결해주기 위한 클래스이다.
         * 해당 클래스의 메서드는 설명만 본다면 사실 이게 무슨 용도인지
         * 도저히 감들이 안오는 메서드들이다. 그냥 바로 써보면서 이해를 해보자.
         */
        try {
            URL url = new URL("https://www.google.com");
            urlConnection = url.openConnection();

            // set 패턴을 이용해서 설정을 할 수 있다.
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);

            // get 패턴을 통해서 가져올 수 있다.
            System.out.println("toString()이 구현되있는 객체 : " + urlConnection);
            System.out.println("사용자 상호작용 : " + urlConnection.getAllowUserInteraction());
            System.out.println("연결시간 : " + urlConnection.getConnectTimeout());
            System.out.println("헤더값 가져오기 : " + urlConnection.getHeaderFields());
            System.out.println("URL로 변경 : " + urlConnection.getURL());
            System.out.println("DoInput값 : " + urlConnection.getDoInput());
        } catch (IOException m) {
            System.out.println("에러에러");
        }

        // 이런식으로 사용할 수 있다.
        BufferedReader bufferedReader = null;
        try {
            URL googleUrl = new URL("https://www.google.com");

            // 출력을 하기 위해서 만든 변수
            String html = "";

            bufferedReader = new BufferedReader(new InputStreamReader(googleUrl.openStream()));
            while ((html = bufferedReader.readLine()) != null) {
                // HTMl 출력을 보고싶다면 주석을 해제
                // System.out.println(html);
            }

            // 스트림은 작업 완료 후 꼭 닫아주자.
            bufferedReader.close();
        } catch (IOException i) {
            System.out.println("주소 확인");
        }

        /**
         * HttpURLConnection은 URLConnection과 용도나 성능적 차이는 크게 없으나
         * 하나의 메서드 disconnect() 때문에 많은 사람들도 해당 메서드를 사용할 것을 권장한다.
         * 아파치의 keep alive 기본값이 on 또는 on으로 설정을 한 페이지일 수 있다.
         * 그리고 해당 메서드는 keep alive 삳태를 해당 메서드로 off 값을 주어 끊을 수 있다.
         *
         * keep alive 란 TCP에서 사용되는 용어로써 TCP 통신의 특성은 1:1 통신으로써
         * 연결의 지속성이 있다. 그리고 keep alive 속성을 on 함으로써 하나의 소켓 연결을
         * 무한정으로 지속할 수 있다. Http에서도 keep alive라는 개념은 존재하는데
         * Http 자체가 state less를 선호하는 방식이다. 쉽게 말하면 받을꺼만 받고 끊겠다이다.
         *
         * 그렇다면 keep alive를 계속 유지하게 되면 문제가 무엇일까?
         * 바로 서버의 메모리 사용량과 소켓의 독과점 문제이다.
         * 간단하게 말하면 성능 하락이 큰 문제이다. 그렇다고 오해는 하면 안되는게
         * 무조건 keep alive를 off 하는게 정답이 아니라는 것이다.
         *
         * 복잡하다면 그냥 http 통신을 할 때 해당 객체를 쓴다고 생각하자.
         */
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL("https://www.naver.com");
            // 캐스팅해서 생성
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // 사용하는 request method 타입을 가져온다. 기본값은 GET 이다.
            System.out.println(httpURLConnection.getRequestMethod());
            // 상태코드값을 가져온다.
            System.out.println(httpURLConnection.getResponseCode());
            // keep alive 를 off 한다.
            httpURLConnection.disconnect();
        } catch (Exception e) {
            System.out.println("http 통신을 한다면 해당 메서드를 권장한다.");
        }

        //JarURLConnection은 Jar 파일을 연결하는데 사용하는 것이므로 여기서는 제외했다.

    }

}
