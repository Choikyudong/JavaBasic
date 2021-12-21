package java_chap1;

// 자바와 클래스

public class Chap_2 {

    public static void main(String[] args) {
        /*클래스 사용하기*/
        // 클래스타입 인스턴스명 = "new" 클래스()
            MyClass   MyClass =  new MyClass();
        // 이렇게 만들어진 MyClass를 "인스턴스"라고 칭한다.
        // 여기서 new는 "키워드"(예약어)로 새로운 객체를 만들 때 사용한다.

        // 만들어진 인스턴스 사용방법
        // 사용할 때 "데이터타입"을 꼭 확인
        int number = MyClass.number; // "인스턴스.값"으로 사용할 수 있다.

        // System.out.println(보고싶은거); <- 로 콘솔창에서 값을 볼 수 있다.
        System.out.println(MyClass.number); // MyClass에 적어뒀던 number의 갑싱 나온다.

        // 선언되기만한 a를 이렇게 사용할 수 있다.
        MyClass.a = 'a';
        System.out.println(MyClass.a);

        // 기존에는 클래스를 사용하기 위해서는 인스턴스화 시켜야 했지만
        // static 키워드를 가지면 같은 클래스에서 생성없이 사용이 가능하다.
        System.out.println(InnerMyClass.i);
        int number2 = InnerMyClass.i;
        System.out.println(number2);
    }

    // 이렇게 클래스안에 또 클래스를 만들 수 있다.
    // 이런걸 내부 클래스 (inner MyClass)라고 부른다.
    // static "키워드"는 해당 클래스(여기서는 Chap_2)가 실행이 될 때 공통 메모리(JVM)에 등록되서
    // 해당(여기서는 Chap_2) 클래스의 어디서든 호출이 가능하다.
    static class InnerMyClass {
        // static 키워드는 클래스뿐만 아니라 변수에서도 사용가능하다.
        static int i = 5;
    }

}

// 클래스를 만드는 방법은 간단하다.
// MyClass 클래스명 {} <- 으로 만들면 된다
// 또한 클래스명은 대문자로 시작하는것이 규칙이다.
class MyClass {
    int number = 5;
    char a;
}
