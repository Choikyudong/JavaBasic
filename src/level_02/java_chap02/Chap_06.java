package level_02.java_chap02;

interface MyLambda {
    int max(int a, int b);
}

// 람다식(Lambda expression)

// JDK 1.8부터 추가된 기능으로 지네릭스에 이어서 자바에 큰 변화를 준 기능이라고 한다.
// 기존의 자바는 객체지향 언어였지만 이 기술을 도입으로 함수형 언어의 기능도 가지게 되었다.
public class Chap_06 {

    // 람다식이란 메서드를 "하나의 식으로 표현하는 것"이다.
    // 메서드를 람다식으로 작성할 경우 메서드의 이름과 반환값이 없어지므로 "익명 함수"라고도 표현한다.

    // 사용을 하다보면 느끼겠지만 람다식으로 메서드를 "변수처럼" 다루는 것이 가능해진다.
    public static void main(String[] args) {
        // 간단한 사용방법을 숙지하자
        // 1. 위의 설명처럼 "익명 함수"답게 메서드에서 이름과 반환타입을 제거
        // 2. 매개변수 선언부와 몸통({}) 사이에 "->"를 추가한다. (진짜로 -> 그대로 입력하면 된다.)

        /* 위의 내용을 이용하면 이렇게 만들어 진다. (메서드의 내용과 결과에 집중보다는 구조에 집중을 하자)

            int max (int a, int b) {                (int a, int b) -> { return a > b ? a : b; }
                return a > b ? a : b;        ==>    (int a, int b) -> a > b ? a : b
            }                                       (a, b) -> a > b ? a : b

            void print(String str) {
                System.out.print(str);       ==>     (str) -> { System.out.print(str); }
            }

            int sqrt(int i) {
                return i * i;                ==>     i -> i * i;
            }

            int random() {
                return (int) (Math.random() * 6);  ==>    () -> (int) (Math.random() * 6)
            }

            위의 몇가지가 람다식으로 변경된 예시인데 작성방법이 특정한 규칙에 의해서 생략이 가능하다.
            1. "매개변수가 하나"일 때 괄호()를 생략가능하다.
            2. "블럭{}안의 문장이 하나" 일 때에는 블럭{}을 생략할 수 있다. 다만 블럭 생략 시에는 ";"도 생략해야 한다.
            3. "블럭{}안의 문장이 return"일 경우 생략할 수 없다.
            4. 람다식에 선언된 "매개변수의 타입을 추론이 가능한 경우 생략이 가능"하다.
        */

        // 자바의 모든 메서드들은 "클래스"에 포함이 되어야 하는데 람다식은 어떤식으로 작성이 되는걸까?
        // 이유는 간단하다 람다식은 메서드처럼 보이지만 실제로는 "익명 클래스"와 동일하기 때문이다.

        /* 이 구성과 비슷하다고 생각을 하면 된다.
                                                          new Object() {
                                                             int max(int a, int b) {
            (int a, int b) -> a > b ? a : b        ==>          return a > b ? a : b;
                                                             }
                                                          }
        */

        // 위의 내용처럼 익명 객체라고 하자 그렇다면 "타입"이 문제가 될것이다.
        // 타입?? l = (int a, int b) -> a > b ? a : b
        // 여기서 타입을 뭘로 해야할지가 문제가 된다.

        // 맨 위에 만들어져있는 인터페이스를 사용하기 위해서 익명 클래스를 생성한다.
        MyLambda l = new MyLambda() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b; // 이렇게 정의를 해주면 사용이 가능!
            }
        };
        System.out.println(l.max(6, 4));

        // 그리고 위의 모양이 람다식과 굉장히 유사한 모습을 보여준다.
        // 즉 위에서 타입에 대한 고민을 인터페이스를 통해서 람다를 다루는 것으로 해결을 한 것이다.

        /*그래서 람다식을 다루기 위한 인터페이스를 "함수형 인터페이스"라고 부른다.*/

        // 이렇게 사용을 할 수 있다.
        Example example = () -> System.out.println("하이요");
        example.method();

        // 만약 형변환을 해야하는 상황이라면 이렇게 해줄 수 있다.
        Example example1 = () -> System.out.println("이렇게");

        // 다만 같은 함수형 인터페이스들만 변환이 가능하다는 점을 숙지하자
        // Example example2 = (Object) () -> System.out.println("ㅜ");

        // 그리고 컴파일러가 람다식의 타입을 어떻게 만드는지 확인을 해보면..
        System.out.println("확인해보자 : " + example);
        // 외부클래스이름&&Lambda&번호/..   <- 이런식으로 만들어진다는 재밌는 사실도 알 수 있다.

        // 사실 엄청나게 큰 변화이기는 하지만 조금 들여다보면 기존에 알고있던 코드가
        // 조금 더 간결해지는것이 아직까지 느낀 전부이다.
    }

    // 해당 애너테이션으로 함수형 인터페이스인것을 정의 할 수 있다.
    // 컴파일러가 제대로된 작성이 됐는지 확인을 해주므로 함수형 인터페이스를 만들 때 꼮 붙여주자.
    @FunctionalInterface
    interface Example {
        // 함수형 인터페이스는 무조건 하나의 추상 메서드만 정의가 가능하다.
        void method();

        // 2개이상일 경우 애너테이션에 의해서 작동이 안된다.
        // int method_2();

        // default 메서드나 static 메서드는 제한없이 사용이 가능하다.
        default void defaultMethod() {}

        static int staticMethod(int a) {
            return a * a;
        }
    }

}
