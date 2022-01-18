package level_01.java_chap00;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 자바와 var
// 자바스크립트에서 봤던 var랑 정말 비슷하게 생긴 녀석이다.
// 자바 10버전부터 추가된 신기능으로 파이썬, 자바스크립트처럼 타입을 추론하여 사용하는 방식이다.
public class Chap_04 {

    // var는 "키워드"로 8버전에서는 사용할 수 없다.
    // 많은 자바개발자들은 var같은 형식을 굉장히 어색해한다.
    public static void main(String[] args) {
        // 기존에는 이런식으로 변수와 객체를 만들었다.
        int i = 5;
        String str = "안녕하세요";

        // 하지만 var를 사용하면 조금 더 단순하게 표현이 가능하다.
        var j = Integer.valueOf(1);
        var str1 = "반갑습니다";
        // 위에처럼 선언을 할 경우 컴파일 시 컴파일러가 해당 값의 타입을 확인하고 지정한다.

        // instanceof 연산자로 비교를 하면 해당 타입으로 변환이 된 것이 확인이 된다.
        System.out.println(j instanceof Integer);
        System.out.println(str1 instanceof String);
        System.out.println("\n");

        // 그렇다면 var를 어떻게 사용을 해야할까?
        List<Object> list = new ArrayList<>(3);

        // 이런 다양한 값들이 들어있다고 가정을 해보자.
        list.add(1);
        list.add("Hello");
        list.add(true);

        // 이제 출력을 해볼건데 내용들을 보면 각자 클래스들이 다르다.
        // 그럴 때 이런식의 표현을 해보는것도 좋다고 생각한다.
        for (var v : list) {
            System.out.println("해당 배열의 값 : " + v);
            System.out.println("해당 배열의 타입 : " + v.getClass());
        }

        // 어떤 타입을 사용할지 모를떄 또는 다양한 타입을 받아야할 때 사용하면 괜찮을 꺼 같은 키워드이다.

        // 또한 예시로 Map타입을 다룰 떄에 사용을 하기도 한다고 한다.
        var mapExample = new HashMap<String, ArrayList<String>>();

        /*---------------------------------------------------------*/
        /*이렇게만 보면 만능 키워드로 보이는데 이제부터 "단점"을 알아보자.*/

        // 밑의 예시처럼 "선언"만 하는것은 불가능하다. 이유는 추론형이기 때문에 어떤 타입인지 모르면 알 수가 없자나
        int a;
        //var var;

        // 객체에는 null값을 할당할 수 있지만 var는 추론형이라 불가능
        Long l = null;
        //var var = null;

        // 배열에는 사용이 불가능하다.
        int[] arr = {1,2,3,4,5};

        // 이렇게는 사용을 못한다.
        //var varArr = {1,2,3,4,5};

        // 만약 var형태로 배열을 선언하고 싶다면
        var varArr = new int[] {1,2,3,4,5};
        // 이렇게 하면 되는데 사실 이렇게 할 바에는 위에처럼 일반적으로 선언이 훨씬 신뢰성이 높다.

        // 람다를 사용할 수 없다.
        // var varLambda = () -> {};

        /*이렇게 장단점이 확실한 키워드로 잘사용한다면 코드라인 수도 줄이고 깔끔해지겠지만*/
        /*반대로 무분별하게 사용할 경우 가독성이 떨어져 다른 사람들에게 혼날 수 있다.*/
    }

}
