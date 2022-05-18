package level_02.java_chap03;

import java_forChap.FilePath;

import java.io.*;
import java.util.Arrays;

/**
 * 자바 입출력
 */
public class Chap_03 {

    public static void main(String[] args)  {
        FilePath filePath = FilePath.PATH;

        byte[] inSrc = {0,1,2,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        // 블락킹 : 데이터를 읽어 올 때 데이터를 기다리기 위해 멈추는 행위
        try {
            // available() :  블락킹없이 읽어올 수 있는 바이트의 수를 반환하는 메서드
            while (input.available() > 0) {
                int length = input.read(temp);
                output.write(temp, 0, length);

                // 처리하는 결과를 보면 차이가 꽤 난다.
                //output.write(input.read());

                outSrc = output.toByteArray();
            }
            System.out.println(Arrays.toString(outSrc));
        } catch (IOException i) {
            System.out.println("실패!");
        } catch (Exception e) {
            System.out.println("시일패!");
        }

        /**
         * FileInputStream, OutputStream
         * 자바프로그래밍에서 많이 사용되는 스트림 중 하나이다.
         */
        // 자바 7버전부터 제공하는 try-with-resource 문법으로 작성해봄, 근데 왜 안됨?
        try (FileInputStream fileInput = new FileInputStream(filePath + "/테스트1.txt");) {
            int data = 0;
            while ((data = fileInput.read()) != -1) {
                char c = (char) data;
                System.out.println(c);
            }
        } catch (IOException i) {
            System.out.println("실패!");
        }

        /**
         * FilterInputStream, OutputStream
         * 바이트기반의 보조스트림으로써 말그대로 보조역할만 한다.
         */
        try {
            FileOutputStream fos = new FileOutputStream(filePath + "/텍스트.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            for (int i = 1; i <= 9; i++) {
                bos.write(i);
            }
            fos.close();
        } catch (IOException e) {
            System.out.println("엥?");
        }

    }

}
