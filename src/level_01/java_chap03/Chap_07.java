package level_01.java_chap03;

// 자바와 인터페이스

// 여기서 배우게 되는 "인터페이스"도 우선은 "추상클래스"라고 생각해도 된다.
// 앞으로 많이 사용하게 될꺼니 개념을 확실히 잡고가야한다.

// 사용방법은 클래스 만드는거와 같다. 딱 하나 입력하는거만 다르다.
// interface 인터페이스명
interface Interface01 {
    void imMethod(); // 이렇게 "정의"만 해주면 된다.
}

// 인터페이스는 인터페이스만 상속이 가능하다. (중요)
// extends 키워드는 같다.
interface Interface02 extends Interface01 {
    @Override
    void imMethod();
    void imMethod2();
}

// 또한 클래스와 다르게 "다중 상속"이 가능하다. (중요)
// 저번에 다룬 추상클래스와의 차이점 중 하나이다.
interface Interface03 extends Interface01, Interface02 {
    // 물론 2개다 오버라이딩 가능
    @Override
    void imMethod();
    @Override
    void imMethod2();
}

// 추상클래스는 사용할 때 귀찮게 abstract를 매번 입력해야 했는데 인터페이스는 안해도 되니까
// 너무 최신식아닌가라고 생각할 수 있지만 사실 전부 입력해야 하는것이 맞다.
interface DetailInterFace {
    String name = "나는 인터페이스";
    void method();
    // 위의 필드와 메서드는 컴파일시에 자동으로 이렇게 바뀐다
    /*
    public static String name = "나는 인터페이스";
    public abstract void method();
     */
    // 위의 인터페이스에도 예외없이 다 적용이 되는것이다.
}

// 좀 더 나아가서 자바8버전부터 지원하는 새로운 기능들을 맛보자.
interface SuperInterFace {
    // default 메서드라고 부른다.
    default void method() {
        System.out.println("default 키워드를 붙이면 구현이 가능하다.");
    }
    // 또한 static 키워드를 이용해서 이렇게 할 수 있다.
    static void hello() {
        System.out.println("static 키워드를 이용할 수 있다.");
    }
}

// 이제 정의된 내용들을 사용하기 위해서 클래스로 "구현"해야한다.
// implements라는 키워드를 사용하며 상속이 아닌 "구현"이라고 칭한다.
class ImClass implements Interface03 {
    @Override
    public void imMethod() {
        System.out.println("저는 메서드1입니다.");
    }

    @Override
    public void imMethod2() {
        System.out.println("저는 메서드2입니다.");
    }
}

// 최신 기능을 이용한 인터페이스도 받자.
class GetSuperInterFace implements SuperInterFace {}

public class Chap_07 {

    public static void main(String[] args) {
        /*만들어진 클래스를 사용해보자*/
        ImClass imClass = new ImClass();
        imClass.imMethod();
        imClass.imMethod2();
        /*문제없이 정의한 내용들이 잘 작동한다.*/

        /*인터페이스 또한 "다형성"의 개념을 이용해서 하면 좋다.*/
        Interface01 interface01 = new ImClass();
        interface01.imMethod();
        /*이렇게 원하는 인터페이스로 갈아치우면서 사용을 할 수 있다.*/

        /*static키워드를 붙였으니 인터페이스를 이렇게도 사용가능하다.*/
        SuperInterFace.hello();

        /*정상적으로 구현화하고 정의된 기본메서드를 사용해보자.*/
        SuperInterFace superInterFace = new GetSuperInterFace();
        superInterFace.method();

        /*또한 인터페이스도 앞에서 말한것처럼 익명객체로 구현이 가능하다.*/
        DetailInterFace detailInterFace = new DetailInterFace() {
            @Override
            public void method() {
                System.out.println("이렇게 익명객체로 구현해도 상관은 없다.");
            }
        };
        detailInterFace.method();

        /*이처럼 인터페이스는 여기서 간단한 예시만 훑어봐도 추상클래스보다 훨씬 자유롭게 쓸 수 있고*/
        /*활용성이 무궁무진하다는것이 첫눈에 봐도 확인이 가능하다.*/

        /*이렇게 추상화와 다형성 기술을 대표적으로 사용하는 기술들인 인터페이스, 추상클래스, 상속 등*/
        /*사실 자바의 객체지향에서 어려운 부분을 한 번 넘겼다고 생각하면 된다.*/

        /*하지만 아무리 개념을 이해하고 사용을 할 줄 안다고해도 왜 사용을 해야 하는지 어디서 사용을 해야하는지*/
        /*모르면 아무런 쓸모가 없을것이다. 사실 처음봐서는 도저히 이해가 안가고 그런 생각이 드는게 당연하다.*/

        /*조금 더 공부하고나서 이유를 알고싶다면 "디자인패턴"을 접하면 비로써 왜 사용을 하고 권장하는지 알게 될것이다.*/

    }

}

