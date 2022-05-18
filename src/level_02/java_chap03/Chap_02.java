package level_02.java_chap03;

import java.io.*;
import java.util.Arrays;

/**
 * 자바 입출력
 * 바이트기반 스트림
 * 앞선 내용을 구체적으로 학습
 */
public class Chap_02 {

    public static void main(String[] args) throws Exception {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;

        // ByteArray...putStream은 임시로 저장을 하는 용도로 주로 사용한다고 한다.
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        /* 버퍼를 사용을 하지않아도 문제는 없다. */
//        inputStream = new ByteArrayInputStream(inSrc);
//        outputStream = new ByteArrayOutputStream();
        inputStream = new ByteArrayInputStream(inSrc);
        outputStream = new ByteArrayOutputStream();

        int data = 0;
        while ((data = inputStream.read()) != -1) {
            outputStream.write(data);
        }

        outSrc = outputStream.toByteArray();
        System.out.println("input : " + Arrays.toString(inSrc));
        System.out.println("output : " + Arrays.toString(outSrc));
        inputStream.close();
        outputStream.close();
        /**
         * 해당 스트림은 메모리밖에 사용을 안하므로
         * 가비지컬렉터에 자동 반환이 되므로 close()를 구지 이용하지 않아도 문제는 없다.
         */
        System.out.println("-----------------------------------------------------------");

        //------------------------------------------------------------------------------
        byte[] input = {0,1,2,3,4,5,6,7,8,9};
        byte[] output = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();

        inputStream1.read(temp, 0, temp.length);
        outputStream1.write(temp, 5, 5);

        output = outputStream1.toByteArray();

        System.out.println("input : " + Arrays.toString(input));
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("output : " + Arrays.toString(output));

        /**
         * 이런식으로 임시 배열(temp)을 생성한 뒤
         * 한번에 데이터를 옮기는 방식으로
         * 효율을 증가시키는 방법도 존재한다.
         */

    }

}
