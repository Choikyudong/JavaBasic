package level_02.java_chap03;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import java.io.*;

/**
 * 자바 입출력
 * 줄여서 I/O(Input/Output)라고 부르기도 하는 이 용어는
 * 장치와 프로그램간의 데이터를 주고받는 행위를 말한다.
 * System.out.print 가 대표적인 예시라고 한다.
 * 자바에서는 java.io 로 기본적인 입출력을 제공해준다.
 */
public class Chap_01 {
    /**
     * 재미있게도 I/O 과정에서는 데이터를 전송하는 통로가 필요한데
     * 이 통로의 이름을 스트림이라고 부른다. 스트림 API와는 전혀 다른 개념이다.
     *
     * 스트림은 단반향통신만 가능하다. 그래서 입력과 출력은 동시에 불가능하다.
     * 만약 입력과 출력이 동시에 필요하다면 스트림이 2개가 필요하다.
     */
    public static void main(String[] args) throws Exception {
        // 해당 추상클래스로 외부정보를 읽는 read()를 구현한다.
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                // 읽을 수 없다면 -1을 반환한다.
                return 0;
            }
        };

        // 해당 추상클래스로 내부정보를 외부로 출력(write)한다.
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                // 해당 메서드로 출력을 한다.
            }
        };

        /* 위의 두 메서드로 기본적인 입출력들을 할 수 있다. */
        
        // 파일과 관련된 스트림
        String filePath = "어디 좋은곳에 저장이 됨!";
        InputStream fileInputStream = new FileInputStream(filePath);
        
        // 메모리관련 스트림
        OutputStream byteOutputStream = new ByteArrayOutputStream();

        /* 이 외에도 기본적인 스트림들이 더 있다. */
        //--------------------------------------------------------------

        /**
         * 보조 스트림
         * 위에서 언급된 기본적인 스트림을 말그대로
         * 보조하기 위해서  탄생된 스트림들이다.
         * 보조이기 때문에 직접적으로 데이터를 송수신 못하지만
         * 기능 추가와 향상에 도움을 줄 수 있다.
         */

        FileInputStream files = new FileInputStream("파일파일");

        // 메인스트림을 기반으로 보조스트림을 생성한다.
        BufferedInputStream stream = new BufferedInputStream(files);
        stream.read();

        /**
         * 위의 예시에서 BufferedInputStream를 통해서 수행하는것처럼 보이지만
         * 실제 입력기능은 FileInputStream가 담당하고 BufferedInputStream은
         * 버퍼만을 제공한다.
         *
         * 이렇게하는 이유는 성능상의 이점이 크기때문에 실제로도 이렇게 한다고 한다.
         */

        //---------------------------------------------------------------

        /**
         * 위에 내용까지가 Byte기반의 스트림들이였다.
         *
         * 그렇다면 이제부터 문자기반 스트림을 간단하게 알아보자.
         * 우선 클래스명을 알아보는것은 간단하다
         * InputStream -> Reader
         * OutputStream -> Writer
         * 이렇게 변경이 되었다.
         */
        // 이게 IntputStream을 대체하는 추상클래스이다.
        Reader reader = new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }
            @Override
            public void close() throws IOException {

            }
        };

        // OutputStream을 대체하는 클래스이다.
        Writer writer = new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {

            }
            @Override
            public void flush() throws IOException {

            }
            @Override
            public void close() throws IOException {

            }
        };

        // 보조소트림도 이름만 변경하면 되니 파악하는게 어렵지 않다.


    }



}
