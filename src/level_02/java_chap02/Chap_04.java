package level_02.java_chap02;

// Enum(열거형)

// 1.5부터 추가가 된 기능으로 상수를 편하게 정의할 때 사용하면 유용하다.
// 자바에서의 열거형은 타입에 안전한 열거형이라 실제 값이 같아도 타입이 다르면 에러가 발생한다고 한다.
public class Chap_04 {

    // 이런식으로 사용을 한다.
    enum Enum {
        a, b, c
    }

    Enum e;

    public void setE(Enum e) {
        this.e = e;
    }

    public static void main(String[] args) {
        Chap_04 chap_04 = new Chap_04();
        chap_04.setE(Enum.a);

        // Enum은 비교에 '=='를 사용할 수 있다.
        // equals가 아닌 '=='로 비교하기 때문에 빠른 성능을 제공한다.
        if (chap_04.e == Enum.a) {
            System.out.println('a');
        } else if (chap_04.e == Enum.c) {
            System.out.println('c');
        }

        // Switch문과 함께 응용해서 사용할 수 있다.
        switch (chap_04.e) {
            case a:
                System.out.println("a입니다.");
                break;
            case b:
                System.out.println("b입니다.");
                break;
            case c:
                System.out.println("c입니다.");
                break;
            default:
                System.out.println("?????");
                break;
        }

        EnumTest e1 = EnumTest.Hello;
        EnumTest e2 = EnumTest.Hi;
        EnumTest e3 = EnumTest.Hey;

        // 열거형에도 간단한 메서드들이 존재하는데 알아보자.

        /*values()*/
        // 열거형을 배열로 변경한다.
        EnumTest[] et = EnumTest.values();
        for (EnumTest e : et) {
            System.out.printf("%s = %d%n", e.name(), e.ordinal());
        }

        /*name()*/
        // 해당 열거형을 문자열로 반환한다.
        String text1 = e1.name();
        System.out.println(text1);

        /*ordinal()*/
        // 열거형이 정의된 순서대로 반환한다. 0부터 시작
        System.out.println(e3.ordinal());

        /*getDeclaringClass()*/
        // 열거형의 Class객체를 반환한다.
        Class<EnumTest> testClass = e2.getDeclaringClass();

        /*valueOf(String)*/
        // 열거형에서 지정된 값과 일치하는 것을 찾는다.
        EnumTest e4 = EnumTest.valueOf("Hey");

        // 존재하지 않는 값이라면 문법예외를 일이킨다.
        // EnumTest e5 = EnumTest.valueOf("HiHi");

    }

}

enum EnumTest {
    Hello, Hi, Hey
}