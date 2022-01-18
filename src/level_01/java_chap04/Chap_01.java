package level_01.java_chap04;

// java.lang 패키지 - 1 (Object)
// java.lang 은 자바프로그래밍의 기본적인 클래스들을 포함하고 있다.
// 그래서 해당 패키지는 import 없이 사용이 가능하다. String, System 클래스가 해당 패키지에 들어있다.
public class Chap_01 {

    // 모든 클래스의 최고 조상인 Object 클래스도 java.lang에 들어있다.
    // Object 클래스는 모든 클래스의 조상이기 때문에 Object 클래스의 멤버를 모든 클래스에서 사용이 가능하다.
    public static void main(String[] args) throws Exception {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        /*equals*/
        // 해당 메서드는 같은 객체인지 확인을 하는 메서드이다.
        if (myClass1.equals(myClass2)) {
            System.out.println("2개는 같은 클래스");
        } else {
            System.out.println("2개는 다른 클래스");
        }
        // 다만 비교를 할 때 참조변수의 값으로 비교를 한다.

        /*hashCode*/
        // 해당 메서드는 해싱기법에 사용되는 해시함수를 구현한 것이다.
        System.out.println(myClass1.hashCode());
        System.out.println(myClass2.hashCode());

        // 여기서 String 클래스를 비교를 하면 같은 값이 나온다.
        String str1 = new String("안녕");
        String str2 = new String("안녕");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        // 왜냐하면 String 클래스에서 같은 문자열이면 같은 해시코드를 반환하게 오버라이드 했기 때문이다.

        // 그래서 진짜 해당 객체의 해시코드를 볼려면 System의 메서드를 사용하면 된다.
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        /*toString*/
        // 인스턴스에 대한 정보를 문자열(String)로 제공할 목적으로 정의한 것이다.
        System.out.println(myClass1.toString());
        // 여기서 toString은 오버라이드가 되지 않은 순수한 toString이다.
        // getClass().getName()+"@"+Integer.toHexString(hasCode()) <- 이렇게 출력이 된다

        // toString을 이용해 문자를 출력하기 위해서는 오버라이드 해야한다.
        MyClass2 toString = new MyClass2();
        System.out.println(toString);
        // 또한 toString 메서드는 Object에서부터 public으로 설정이 되어있다.
        // 상속시 조상에서 정의된 제어자보다 범위가 좁아지면 안된다.

        /*getClass*/
        // 자신이 속한 클래스의 Class 객체를 반환하는 메서드이다.
        // Class 객체는 클래스의 모든 정보를 담고 있으며, 클래스 당 1개만 존재한다.
        // 그리고 클래스 파일이 "클래스 로더"에 의해서 메모리에 올라갈 때 자동 생성된다.
        Class classClass = new MyClass2().getClass();
        // 이런식으로 해당 클래스의 정보를 가져올 수 있다.
        // 클래스객체를 이용하면 멤버 이름, 개수 등 클래스의 모든 정보를 얻을 수 있다.

        MyClass2 myClassObj1 = new MyClass2(); // 기본적으로 생성하는 방법
        MyClass2 myClassObj2 = MyClass2.class.newInstance(); // Class 객체를 이용해서 생성하는 방법
        // 다만 newInstance 사용방법은 그렇게 권장하는 방법은 아니라고 한다.
        // 만약 동적으로 클래스를 생성하고 싶다면 reflection API를 사용하는 것을 권장한다.

        /*이 외에도 Object 클래스에는 clone()메서드가 대표적으로 하나 있는데 여기서는 생략한다.*/
    }

}

class MyClass {}

class MyClass2 {
    String name;
    MyClass2() {
        this("나는 클래스!");
    }
    MyClass2(String name) {
        this.name = name;
    }

    // 이렇게 toString을 오버라이드하면 된다.
    @Override
    public String toString() {
        return "MyClass2{" +
                "name='" + name + '\'' +
                '}';
    }
}
