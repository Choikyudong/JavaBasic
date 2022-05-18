package level_02.java_chap03;

import java_forChap.FilePath;

import java.io.*;

/**
 * 자바 입출력
 * 문자기반 스트림
 */
public class Chap_05 {

    /**
     * 이전에 다뤘던 바이트기반의 스트림과 딱 하나의 차이점이 있는데
     * 문자를 다루는 것이다. 그거말고는 다른점이 없다고 한다.
     */
    public static void main(String[] args) {
        FilePath filePath = FilePath.PATH;

        Reader reader;
        Writer writer;
        /**
         * 바이트기반의 스트림이 InputStream, OutputStream을 기반으로
         * 작동한다면 문자기반은 두개의 클래스를 기반으로 작동한다.
         *
         * 기존의 스트림은 1byte로 스트림을 처리했고
         * 문자기반의 스트림은 2byte로 스트림을 처리하는데
         * 여기서 중요한점은 "인코딩"이 필요한것이다.
         *
         * 이유는 간단하게 생각해서 "문자"를 다루기 때문이라고 생각하자.
         */

        FileReader fileReader; FileWriter fileWriter;
        /**
         * 해당 클래스로 파일의 "텍스트"를 읽고 쓴다.
         */
        // 근데 이거 경로가 둘 다 인식은 된다?
//        File file = new File("D:\\자바실습\\파일\\파일리더테스트.txt");
        File file = new File(filePath.getPath() + "/파일리더테스트.txt");
        try(FileReader fileTest = new FileReader(file)) {
            int data = 0;
            while ((data = fileTest.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException i) {
            System.out.println("???????");
        } finally {
            System.out.println();
        }

        // 위의 예시를 앞서서 다뤘던 byte기반 스트림으로 해보자, 스트림만 바꿔서 진행을 해봄
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            int data = 0;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException i) {
            System.out.println("뭐임?");
        } finally {
            System.out.println();
        }

        /**
         * 결과를 보면 알듯이 Reader를 이용하면 글자를 정상적으로 가져오지만
         * Byte기반의 스트림은 정상적으로 작동하지 않는다.
         */

        PipedReader pipedReader; PipedWriter pipedWriter;
        /**
         * 기존의 스트림은 입력과 출력의 스트림이 각각 존재했는데
         * 해당 스트림은 입력과 출력이 하나의 통로로 된다는것이 가장 큰 특징이다.
         * 그래서 하나의 스트림을 닫으면 반대쪽도 같이 닫힌다는것을 기억
         *
         * 주로 쓰레드 간에 데이터를 전송할 떄 사용한다고 한다.
         */
        InputThread inputThread = new InputThread("내가 받을꺼임 ");
        OutputThread outputThread = new OutputThread("내가 보낼꺼임 ");

        inputThread.connect(outputThread.getOutput());

        inputThread.start();
        outputThread.start();
        /**
         * 해당 클래스는 쓰레드를 위해 존재하는 것을 알 수 있다.
         */

        StringReader stringReader; StringWriter stringWriter;
        /**
         * 입출력대상이 메모리인 스트림으로 Writer로 출력되는 데이터는 내부의
         * StringBuffer에 저장되며 getBuffer()또는 toString()으로 반환이 가능하다.
         */
        String exampleText = "안녕하세요 여러분들 반갑습니다!";
        StringReader sr = new StringReader(exampleText);
        StringWriter sw = new StringWriter();

        int data = 0;

        try {
            while ((data = sr.read()) != -1) {
                sw.write(data);
            }
        } catch (IOException io) {
            System.out.println("!!!");
        }

        System.out.println("출력 : " + sw);
        System.out.println("출력 : " + sw.getBuffer().toString());

    }

}

/** 
 * 쓰레드에 대한 내용은 후에 다룰예정
 * 여기서 Piped..스트림을 사용하기 위해서 쓰레드를 만들어줌
 */
class InputThread extends Thread {
    PipedReader pipedReader = new PipedReader();
    StringWriter writer = new StringWriter();

    InputThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int data = 0;
            while ((data = pipedReader.read()) != -1) {
                writer.write(data);
            }
            System.out.println(getName() + "<- 얘가 받았음 : " + writer.toString());
        } catch (IOException i) {
            System.out.println("띠용?");
        }
        super.run();
    }

    public PipedReader getInput() {
        return pipedReader;
    }

    public void connect(PipedWriter pipedWriter) {
        try {
            pipedReader.connect(pipedWriter);
        } catch (IOException i) {
            System.out.println("connect 문제발생");
        }
    }

}

class OutputThread extends Thread {
    PipedWriter pipedWriter = new PipedWriter();

    OutputThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            String msg ="안녕하세요!";
            System.out.println(getName() + "<- 얘가 보냄 : " + msg);
            pipedWriter.write(msg);
            pipedWriter.close();
        } catch (IOException i) {
            System.out.println("띠용?");
        }
        super.run();
    }
    public PipedWriter getOutput() {
        return pipedWriter;
    }

    public void connect(PipedReader pipedReader) {
        try {
            pipedWriter.connect(pipedReader);
        } catch (IOException i) {
            System.out.println("connect 문제발생");
        }
    }

}