package level_02.java_chap03;

import java_forChap.FilePath;

import java.io.*;
import java.util.Formatter;

/**
 * 자바 입출력
 * 보조스트림
 */
public class Chap_04 {

    public static void main(String[] args) {
        /**
         * 모든 보조스트림의 조상격인 해당 클래스는
         * InputStream, OutputStream을 매개변소로 사용이 가능하다.
         * 말그대로 보조역할을 하는 클래스이기 때문에 윗줄에서 언급한
         * 매개변수가 없다면 아무런 기능도 하지못하는 클래스이다.
         */
        FilterInputStream filterInputStream;

        // 버퍼를 이용하여 스트림의 입출력 효율을 높이는 보조스트림이다.
        // FilterInputStream 을 상속받은 클래스이다..
        BufferedInputStream bufferedInputStream;

        // 위와 마찬가지로 역시 버퍼를 이용하여 출력을 하는 클래스이다.
        BufferedOutputStream bufferedOutputStream;

        /**
         * 버퍼로 출력을 할 경우 write()를 사용하는데
         * 출력내용을 전부 버퍼에 담고 가득찰 경우
         * 버퍼의 모든 값들을 출력을 하는 구조이다.
         * 그리고 다음 값들을 버퍼에 담고, 가득차면 보내는 형식이다.
         *
         * 주의점은 버퍼가 가득찼을 때만 출력하기 때문에
         * 해당 버퍼에 버퍼가 남아있는채로 프로그램이 종료가 될 수 있다는 것이다.
         * 그래서 close() 또는 flush()로 해당 버퍼의 모든 내용을 출력하도록 해야한다.
         */

        DataInputStream dataInputStream;
        /**
         * 해당 클래스는 조금 어렵게 말하면 16진수로 자바의 기본자료형을 표현하고 저장한다.
         * 쉽게말하면 기본 자료형의 단위를 읽고 쓸 수 있다는것이다.
         */

        SequenceInputStream sequenceInputStream;
        /**
         * 해당 보조스트림은 여러 개의 입력스트림을 연속적으로 "연결"해서 하나의 스트림으로
         * 데이터를 읽는것과 같은 방식을 제공해준다고 한다.
         * 보통은 큰 파일을 여러 개의 작은 파일로 나누고 하나의 파일로 합칠 때 사용한다고 한다.
         *
         * 특이사항으로는 Filter를 상속하는것이 아닌 바로 InputStream을 받는다는 것이다.
         */

        PrintStream printStream;
        /**
         * 다양한 형태로 출력을 가능해지도록 print, println, printf 같은 메서드를 오버라이딩하여 제공한다
         * 해당 클래스가 바로 System.out.print의 기능을 제공하는 클래스이다. 알게모르게 많이 사용한 클래스
         * 하지만 해당 클래스보다는 PrintWriter가 더 다양한 문자를 처리하는데 적합해서 PrintWriter를 추천한다.
         */

    }

}

// 추가적인 내용
class AnotherSubjectClass {
    // 이런 키워드는 아마도 본적이 없을것이다.
    volatile int number = 0;

    /**
     * volatile은 동기화와 연관도 있고 메모리구조와도
     * 연관이 있는 키워드로 해당 키워드를 사용한 변수는
     * 항상 메인메모리에 저장이 된다.
     *
     * 이런 기능이 왜 필요하냐면
     * 하나의 프로그램에는 동시에 많은 사용자들이 작업을 할 때가 있다.
     * 위에 적힌 number라는 변수값은 로그인이 실행될 때마다
     * 값을 증가시켜야하는 필드값이라고 생각을 해보자.
     *
     * 해당 필드값을 사용하는데 메서드가 아마도 이렇게 존재할것이다.
     * void 메서드명(UserLoginVO user) {
     *      if (user != null) {
     *          this.number += 1;
     *      } else {
     *          throw new Exception();
     *      }
     * }
     *
     * 해당 메서드로 현재 전체 유저수를 관리를 한다면
     * 해당 값은 모든 영역에서 항상 일치를 해야하는데
     * 이 때 volatile이라는 키워드로 모든 영역에서 사용할 값을
     * "메인메모리에"에 저장시킬 수 있다.
     *
     * 그렇다면 여기서 메인메모리가 왜 갑자기?라는 생각이 들 수 있다.
     * 이 부분은 자바의 영역보다는 cpu 작업방식을 참고를 하는게 좋다고 한다.
     */
}