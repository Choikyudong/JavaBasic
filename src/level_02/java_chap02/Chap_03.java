package level_02.java_chap02;

import java.util.List;

/*지네릭스(Generics)*/
public class Chap_03 {

    public static void main(String[] args) {
        // 지네릭스에는 와일드 카드라는 재미난 기능이 있다.
        /*
            이렇게 할 경우 오버로딩이 될 거 같지만 성립하지 않는다.
            지네릭은 컴파일 시 사용하고 제거되는 기능이기 때문에 둘은 같은 메서드로 본다.
            static void doMethod(GTest<Value1> something) {}
            static void doMethod(GTest<Value2> something) {}
        */

        // 이런 상황을 해결하고 나타난 기능이 와일드 카드이다.
        // "?" 로 와일드 카드를 표현한다.
        /*
            <?> : 제한없음, 모든 타입이 가능. 사실상 <? extends Object>랑 동일하다.
            <? extends T> 와일드 카드의 "상한 제한", T와 그 자손들만 가능
            <? super T> 와일드 카드의 "하한 제한", T와 그 조상들만 가능
        */

    }

    // 그리고 메서드에도 지네릭을 넣을 수 있다.
    static <T> void method() { // 지네릭 메서드라고 부른다, 반환 타입의 앞에 선언한다.

    }

    // 이 상황에서 T는 모두 같은 타입이 아니다.
    // 같은 T를 쓴다고 같은 타입을 사용하는 것이 아니다.
    static class TestClass<T> {
        <T> void method(List<T> list) {

        }
    }

    // 여기까지 지네릭스의 기본적인 부분이다.

}
