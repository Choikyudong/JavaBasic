package level_01.java_chap03;

// 메서드와 오버로딩

/*printf는 형식화된 출력으로 기존의 println은 들어온 값을 그대로 출력이지만*/
/*printf는 매개변수값을 출력형식에 넣는다던지 다양하게 활용이 가능하다.*/
public class Chap_04 {

    // void는 해당 메서드는 반환값이 없다는 의미이다.
    public void method() {
        System.out.printf("메서드입니다.\n"); // \n은 이스케이프 문자로 한줄을 바꾸는 기능을 가졌다. printf랑은 상관없는 기능임
    }

    // java_chap01 - Chap3에서 메서드에 대해 이야기를 한적있다.
    // 이번에는 다시 메서드를 기억할겸 오버로딩에 대해서 이야기를 한다.
    public static void main(String[] args) {
        /*우선 메서드는 클래스에서 정의한 하나의 동작기능이다.*/
        Chap_04 현재챕터 = new Chap_04();
        현재챕터.method(); // 이렇게 "."으로 해당 클래스의 기능과 필드값에 접근가능하다.

        /*위에서 정의한 method_1가 존재하고 회사에서 사랑받는? 메서드이다.*/
        /*그리고 상사인 홍길동씨가 해당 메서드의 이름은 놔두고 재활용을 해라고 했다.*/

        /*변수명이나 클래스명이 중복이 되면 안되는것처럼 메서드도 중복이 안되면 안되는거 아닌가?*/
        /*라고 생각하면 50%는 맞는데 50%는 틀렸다. 조건이 맞으면 메서드명은 중복되도 상관이 없다.*/

        /*조건은 매개변수의 "개수" 또는 "타입"이 달라야 하는 것이다.*/
        /*그리고 해당 조건에 맞춰서 같은 변수명으로 메서드를 제작을 했다면, 그게 바로 "오버로딩(overloading)"이다*/
        현재챕터.method("홍길동"); // 똑같은 메서드명이지만 기능이 바뀌었다.
        int result = 현재챕터.method(25); // 받은 값을 출력하기 위해서 result라는걸로 받아본다.
        System.out.println(result);
        
        /*그리고 알고있는지는 모르겠지만 사실 오버로딩으로 정의된 기능을 사용하고 있었다.*/
        /*그게바로 println()이다.*/
        System.out.println(1);
        System.out.println(5L);
        System.out.println(0.5f);
        System.out.println('a');
        System.out.println("ㅎㅇ");
        /*전부 다른값인데 println()은 오버로딩으로 정의되었기 때문에 다양한 값들을 받을 수 있는것이다.*/

        /*그렇다면 왜(?) 그냥 다른 이름으로 만들면 되지 왜(?) 이런짓(?)을 한다는건가*/

        /*우선 메서드명이라는 것은 해당 예시처럼 아무생각없이 만들지 않는다.*/
        /*메서드명을 작명할 때에는 이름만 보고 해당 메서드는 대충 이런 기능이겠네라고 예측을 할 수 있도록 제작해야한다.*/
        /*또한 클래스명, 변수명 모든 이름을 정식으로 프로그래밍할때에는 예측이 가능하게 제작을 해야한다.*/

        /*그리고 이렇게 오버로딩을 하면 메서드명을 아낄 수 있다는 것이다. 처음에는 "이런게 장점?"인가 라고 생각했는데*/
        /*생각보다 메서드명 작명과 선택이 어려우니 이런식으로 아낄 수 있다는것은 장점이라고 말할 수 있다.*/

        /*그리고 전 챕터에서 다뤘던 생성자도 메서드의 일종이다.*/
        /*그래서 매개변수가 없는거도 그낭하고 int를 넣어도 되고 모두 되는것이다.*/
        OverLoading loadingExample1 = new OverLoading();
        OverLoading loadingExample2 = new OverLoading("안뇽!");
        OverLoading loadingExample3 = new OverLoading("안뇽!", "안녕하세요");
    }

    // 위에있는 method를 오버로딩해보자
    void method(String name) {
        System.out.printf("%s입니다.\n", name); // %s는 String값을 넣는다는 의미이다.
    }

    // 이제는 숫자를 넣어보자 그리고 반환값을 받아보자
    int method(int number) {
        return number + 100; // 들어온 매개변수값에 100을 더하는 기능을 넣어보자.
    }

    // 현재챕터 클래스의 기본생성자(입력을 안하면 컴파일러가 자동으로 생성한다)

}

class OverLoading {
    OverLoading() {
        System.out.println("안녕");
    }
    OverLoading(String hello) {
        System.out.println(hello);
    }
    OverLoading(String hello, String hi) {
        System.out.printf("%s의 뜻은 %s입니다.", hello, hi);
    }
}