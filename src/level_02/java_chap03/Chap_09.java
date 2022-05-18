package level_02.java_chap03;


import java_forChap.ser.ChildClass;
import java_forChap.ser.DataObject;
import java_forChap.FilePath;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 직렬화(Serialization)
 * 객체를 데이터 스트림으로 만드는 것을 뜻한다.
 * 네트워크 또는 다른 프로그램에 전송하고
 * 다시 파일로 재구성 할 수 있는 포맷으로 변환하는 과정이다.
 *
 * 그리고 역직렬화는 직렬화의 반대 개념으로
 * 외부에서 받은 객체를 우리가 읽을 수 있도록 변환하는 과정이다.
 *
 * 직렬화 진행 시 필드값들만 저장이 되고 메서드는 저장이 되지 않는다.
 */
public class Chap_09 {

    // 객체를 직렬화가 가능한 상태로 만드는것은 간단하다. Serializable을 구현하면 된다.
    class SObj implements Serializable {
        // Serializable는 아무런것도 구현이 되어있지 않지만 이것으로 JVM이 직렬화 객체여부를 판단한다.
    }

    class SEObj extends SObj {
        // 직렬화를 구현한 객체를 상속받으면 해당 객체 또한 직렬화가 가능하다.
        // 또한 해당 객체를 직렬화한다면 부모 객체의 값들도 직렬화가 된다.
    }

    class NObj {
        // 평범한 클래스
    }

    class NSObj extends NObj {
        /**
         * 이런 경우에는 NObj의 값들은 직렬화가 되지 않는다.
         * 또한 해당 상태에서 직렬화를 한다면 예외가 발생한다.
         *
         * 직렬화 대상이 아닌 값들 즉 조상클래스의 값들 때문이다.
         *
         */

        // 추가로 직렬화 대상에서 제외하고 싶다면 transient 키둬드를 사용하면 된다.
        transient String password; // null 값으로써 들어간다.
    }

    public static void main(String[] args) {
        FilePath filePath = FilePath.PATH;

        // 직렬화 파일의 확장자는 .ser로 하는것이 관례라고 한다.
        String fileName = "DataObject.ser";
        File file = new File(filePath.getPath() + "/" + fileName);

        // ObjectOutputStream가 직렬화를 실행하는 스트림이다.
        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oops = new ObjectOutputStream(bos);) {

            DataObject obj1 = new DataObject("바보", "12345");
            DataObject obj2 = new DataObject("멍청이", "54321", "시쿠릿");

            List<DataObject> list = new ArrayList<>();
            list.add(obj1);
            list.add(obj2);

            // 직렬화 실행, writeObject로 객체형태를 직렬화 할 수 있다.
            oops.writeObject(obj1);
            oops.writeObject(obj2);
            oops.writeObject(list);
            System.out.println("직렬화 하는건 사실 자바에서 다 알아서 처리해준다.");
        } catch (IOException io) {
            System.out.println("문제생김");
        }

        // 역직렬화는 ObjectInputStream를 통해서 진행한다.
        try (FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);) {

            // 직렬화를 했던 순서 그대로 가져와야 한다. 순서가 다를 경우 ClassCastException이 발생한다.
            DataObject obj1 = (DataObject) ois.readObject();
            DataObject obj2 = (DataObject) ois.readObject();

            // 이런점 때문에 컬렉션 등을 이용하면 직렬화가 조금 더 편하다.
            List<DataObject> list = (ArrayList) ois.readObject();

            // transient로 인하여
            System.out.println(obj1);
            System.out.println(obj2);
            System.out.println(list);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("catch문은 이렇게 2개이상을 동시에 처리할 수 있다.");
        }

        // 직렬화 커스터마이징 같은 경우는 아래의 클래스를 참고하자.
        ChildClass childClass;

        /**
         * 다만 이런 방식의 직렬화에는 아주 큰 단점이 존재하는데
         * 해당 클래스의 값이 조금만 변경이 되어도 인식을 할 수 없다는 점이다.
         *
         * 그래서 고유의 번호값을 준다.
         */
        class SerialUID {
            // 키워드와 변수명까지 모두 고정값이다. 정수값은 사용자가 선택해서 넣어도 된다.
            static final long serialVersionUID = 1532528972348950L;
        }

    }

}
