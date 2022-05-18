package level_02.java_chap03;

import java_forChap.FilePath;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 표준입출력
 */
public class Chap_07 {

    public static void main(String[] args) throws IOException {
        FilePath filePath = FilePath.PATH;
        /**
         * 자바에서는 콘솔창에 데이터를 출력하기 위해서
         * 기본적으로 3가지의 입출력 스트림을 제공한다.
         * 1. System.in : 콘솔로부터 데이터를 입력받는데 사용
         * 2. System.out : 콘솔로부터 데이터를 출력하는데 사용
         * 3. System.err : 콘솔로부터 데이터를 출력하는데 사용
         * 
         * 딱 이런게있다 정도만 알고 넘어가자
         */

        RandomAccessFile raf;
        /**
         * 해당 클래스는 DataOutput, DataInput 두 개를 구현하여 사용하는 클래스로
         * 장점은 파일의 어느 위치에나 읽기/쓰기가 가능하다고 한다.
         * 다른 입출력클래스들은 순차적으로 진행된다고 한다.
         *
         * 이유는 파일 포인터라는 개념을 적용을 하여서 원하는 곳에 포인터를 옮겨서 작업을 하면 된다.
         */
        // 해당 클래스를 이용할 때 두번째 파라미터에 "모드"를 설정해야한다.
        // r : 파일 읽기만, rw : 파일 읽기 쓰기, rws : rw + 파일의 메타정보 포함, rwd : rw + 파일내용만
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath.getPath() + "/RandomAccessFile.txt", "rw");) {
            System.out.println("파일 포인터 위치 확인 : " + randomAccessFile.getFilePointer());
            randomAccessFile.writeUTF("아무말 대잔치");
            System.out.println("파일 포인터 위치 확인 : " + randomAccessFile.getFilePointer());
            System.out.println("몇칸 건너 뛰기! : " + randomAccessFile.skipBytes(10));
            randomAccessFile.writeChars(" 이런 방법도 있지롱~!");
            System.out.println("파일 포인터 위치 확인 : " + randomAccessFile.getFilePointer());
        } catch (IOException io) {
            System.out.println("???!?!?!");
        }
        // 추가적으로 포인터라는 개념은 내부적으로 모두 가지고있지만 해당 클래스만 위치를 마음대로 변경이 가능하다고 한다.

        int[] numbers = {
                124, 34, 653, 123, 45, 1, 745, 34632
        };

        try (RandomAccessFile raf2 = new RandomAccessFile(filePath.getPath() + "/숫자옮겨쓰기.txt.txt", "rw")) {
            for (int i = 0; i < numbers.length ; i++) {
                raf2.write(numbers[i]);
            }
            // 주의할점은 기록이 완료된 시점에서의 포인터의 위치는 파일의 마지막 위치이다.
            // 그렇기에 밑의 함수로 포인터의 위치가 조정되지 않는다면 EOF가 발생한다.
            raf2.seek(0); // 가장 앞으로 옮긴다.
            while (true) {
                System.out.println(raf2.readInt());
            }
        } catch (FileNotFoundException fnfo) {
            System.out.println("??!?!?!?!?!?");
        } catch (EOFException eof) {
            System.out.println("더 이상 읽을 내용이 없을 때 발생한다");
        }

        /**
         * 그래서 RandomAccessFile의 rw 모드를 사용할 때 포인터의 위치를 주의해야한다.
         */

    }

}
