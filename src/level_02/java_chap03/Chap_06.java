package level_02.java_chap03;

import java_forChap.FilePath;

import java.io.*;
import java.util.Properties;

/**
 * 자바 입출력
 * 문자기반 보조스트림
 */
public class Chap_06 {

    public static void main(String[] args) {
        FilePath filePath = FilePath.PATH;

        BufferedReader bufferedReader; BufferedWriter bufferedWriter;
        /**
         * 역시나 버퍼를 이용해서 효율을 높여주는 클래스들이다.
         */

        try (FileReader fileReader = new FileReader(filePath.getPath() + "/BufferedReader.txt")) {
            bufferedReader = new BufferedReader(fileReader);

            String line = "";

            for (int i = 1; (line = bufferedReader.readLine()) != null; i++) {
                // .이 있다면 해당 줄을 읽어서 가져온다
                if (line.contains(".")) {
                    System.out.println(i + " : " + line);
                }
            }

        } catch (IOException io) {
            System.out.println("파일 경로를 다시 살펴봅시다!");
        }

        InputStreamReader inputStreamReader; OutputStreamWriter outputStreamWriter;
        /**
         * 바이트기반의 스트림을 문자기반의 스트림으로 연결을 해주는 역할을 한다.
         * 또한 바이트 기반의 스트림을 지정된 인코딩 문자데이터로 변환하는 작업을 수행한다.
         * 인코딩을 지정해 주지 않는다면 OS의 인코딩을 사용한다. 해당 사항은 입출력 모두 해당된다.
         */
        // OS의 인코딩 종류를 알 수 있는 방법중 하나라고한다.
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("sun.jnu.encoding"));

        // Scanner를 이런식으로 구현할 수 있다.
        try (InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader bufferReader = new BufferedReader(reader)) {
            System.out.println("인코딩스타일 : " + reader.getEncoding());
            String text = "";
            do {
                System.out.println("끌낼려면 q를 입력하세요!");
                text = bufferReader.readLine();
                System.out.println("입력내용 : " + text);
            } while (!text.equalsIgnoreCase("q"));
            System.out.println("대화끝!");
        } catch (IOException ioException) {
            System.out.println("?!?!?!?!?!?!?!?!?");
        }

    }

}
