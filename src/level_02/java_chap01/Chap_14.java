package level_02.java_chap01;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/*자바와 컬렉션프레임워크*/
// Properties
// HashMap의 구버전 HashTable을 상속받아 구현한 것으로
// 기존에 맵들은 (Object, Object) 형식인데 해당 방식은 (String, String)으로 저장하는 방식이다.

// 스프링을 사용해봤다면 .properties라는 파일들을 봤을 것이다.
// 해당 클래스는 그런 설정들을 하는데 주로 사용하고 있는 클래스이다.
// 꼭 지금 당장 알아야하는 클래스는 아니지만 알아두면 도움이 될 클래스일 것이다.
public class Chap_14 {

    // 속성값을 다루는 클래스라고 특별한건 없고 Map의 특성도 변함없이 똑같다.
    public static void main(String[] args) throws Exception {
        // Properties 객체를 생성한다.
        Properties properties = new Properties();

        // 지정된 Properties 목록을 가진 Properties 객체를 생성한다.
        Properties properties1 = new Properties(properties);

        /*setProperty(String, String)*/
        // 지정된 키와 값을 저장한다.
        // 반환타입 : Object
        properties.setProperty("속성1번", "뭐하는 용도일까요?");
        properties.setProperty("필수1번", "뭐하는 용도일까요?");
        properties.setProperty("필수2번", "뭐하는 용도일까요?");
        properties.setProperty("필수3번", "뭐하는 용도일까요?");
        properties.setProperty("필수4번", "뭐하는 용도일까요?");

        /*getProperty(String)*/
        // 지정된 키의 값을 반환한다. 없는 값은 null이 나온다.
        // 반환타입 : String
        System.out.println("getProperty");
        System.out.println(properties.getProperty("속성1번"));
        System.out.println(properties.getProperty("속성2번"));
        // 해당 키가 없을 경우를 대비해서 기본값을 넣을 수 있다.
        System.out.println(properties.getProperty("속성3번", "없나요?"));

        /*propertyNames()*/
        // 목록의 모든 "키"값을 반환한다.
        // 반환타입 : Enumeration
        Enumeration<?> enumeration = properties.propertyNames();
        System.out.println("\npropertyNames");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        /*list(PrintStream), list(PrintWriter)*/
        // 저장된 목록을 출력한다.
        // 반환타입 : void
        /*두개의 클래스는 지금까지 계속 사용해오던 "out.println()" 처럼 입출력을 담당하는 클래스라고 생각하자*/
        System.out.println();
        properties.list(System.out);

        /*load(InputStream), load(Reader)*/
        // 지정된 객체로 목록을 읽은 뒤 저장한다.
        // 반환타입 : void
        Properties prop1 = new Properties();
        try {
            prop1.load(fileInputStream());
        } catch (IOException ioException) {
            System.out.println("지정된 파일을 찾을 수 없습니다.");
            // 0을 넣을경우 프로그램이 종료된다.
            System.exit(0);
        }
        System.out.println(prop1.getProperty("Hello"));
        System.out.println(prop1.getProperty("Java"));
        System.out.println(prop1.getProperty("Props"));

        /*store(OutPutStream, String), store(Writer, String)*/
        // 지정된 객체로 목록을 출력한다. String은 목록에 대한 주석으로 저장이 된다.
        // 반환타입 : void
        Properties prop2 = new Properties();
        // 실제로 스프링부트에서 기본적으로 제공하는 .properties를 이런식으로 설정한다.
        prop2.setProperty("url", "localhost...");
        prop2.setProperty("username", "dong");
        prop2.store(fileOutputStream(), null);

        // 이 외에도 XML 파일을 이용해서 설정을 하는 방법 등이 있다.
        // 해당 클래스는 지금당장 꼭 알아야하는 클래스는 아니지만
        // 조금 더 발전하고 싶다면 알아두면 좋은 클래스인건 확실하다.

    }

    static FileInputStream fileInputStream() throws FileNotFoundException {
        return new FileInputStream("src/java_forChap/PropertiesLoadTest.text");
    }

    static OutputStream fileOutputStream() throws FileNotFoundException {
        return new FileOutputStream("src/java_forChap/PropertiesStoreTest.properties");
    }


}
