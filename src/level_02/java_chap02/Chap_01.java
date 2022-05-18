package level_02.java_chap02;

import java.util.*;

/*제네릭스(Generics)*/
// 다들 제네릭 또는 지네릭스라고 많이 부른다. 제네릭스로 부르는게 습관이 되서 못고치겠다;

// 자바 1.5버전에서 가장 큰 변화라고 불리는 기능이 제네릭스이다.
// 현재는 해당 기능을 모르면 심화적인 부분은 거의 제대로 즐기지 못할 수준이 되었다.
// 처음 보기에는 굉장히 쉬운 내용이지만 보면 볼수록 파면 팔수록 더 어려운 파트이다.
public class Chap_01 {

    // 기능을 간단하게 설명하면 "컴파일 시 타입체크"를 해주는 기능이다.
    // 이렇게하면 객체의 타입 안전성을 높이고 형변환의 번거로움을 줄이는 등 장점이 많다.
    public static void main(String[] args) {
        // 지금까지도 계속 은글슬쩍 사용하고 있던 기능이다.
        // 컬렉션 프레임워크에서 특히 제네릭스를 많이 채택한다.

        /* <Object> <- 이렇게 원하는 타입(객체)를 넣어주면 끝이다.*/
        List<String> list = new ArrayList<>(); // 컬렉션 배우는 시간 아님

        // 이제 해당 리스트는 String.class만 저장할 수 있는 몸이 되었다.
        list.add("안녕!");
        //list.add(5); 본인이 IDE를 사용하고 있다면 이미 빨간줄이 나오면서 불가능하다고 표시가 나온다.
        //list.add('a');

        /*간단한 사용방법과 다르게 정말 확실한 효과가 있는 기능이다.*/
    }

    // 제네릭스는 클래스와 메서드에 선언이 가능하다.
    // 이런 클래스가 하나 있다고 생각하자.
    // 해당 클래스는 보이는것처럼 Object를 엄청 많이 쓴다. 이 클래스를 제네릭스 표현으로 바꿔보자
    static class GTest1 {
        Object object;
        void doMethod(Object o) {
            this.object = o;
        }
    }

    // 이제 제네릭스를 이용했는데 여기서 GTest2<T>의 T를 "타입 변수(Type variable)"라고 부른다.
    // T를 쓴 이유는 타입 변수의 T를 따온 것 뿐이다. 만약 T 혐오증이거나 T가 너무 싫다하면 A로 해도 되고
    // 아무 글자나 입력을 해도 상관이 없다. 물론 클래스명(이미 존재하는)과 겹치게 하면 안된다.
    static  class GTest2<T> { // T는 아무런 효과는 없다. T로 나타내고 싶은 것은 "임의의 참조형 타입"을 사용한다는 것이다.
        T object;
        void doMethod(T o) {
            this.object = o;
        }
    }
    // 여담으로 컬렉션을 다룰 때 기본 문서를 들어간 사람이라면 <E>를 봤을 껀데
    // 그 E도 Element의 첫 글자를 따온 것 그 이상의 의미도 없다.
    // 물론 Map도 <K, V>라고 입력이 되어있는데 K는 Key, V는 Value이다 이렇게 네이밍하는것도 좋다고 생각한다.

    // 위의 코드에서 T대신 "String"를 지정했다면 이렇게 작성된 거와 같다고 생각하면 된다.
    static class GTest3 {
        String object;
        void doMethod(String o) {
            this.object = o;
        }
    }

    /*여기까지가 지네릭스(앞으로 이렇게 부를꺼임)의 도입분이다. 이제 본격적으로 지네릭스를 알아보자.*/

}
