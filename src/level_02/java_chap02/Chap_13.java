package level_02.java_chap02;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * 스트림5
 * 스트림을 배우다 보면 Optional를 많이 보게 되는데
 * 스트림에서 최종결과값으로 사용할뿐만 아니라
 * 더 나아가서 객체 보호와 안전을 위해서 많이 사용하는 래퍼 클래스이니 꼭 알아두자
 */
public class Chap_13 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        myData.setName("데이터");
        /**
         * 8버전부터 util에 추가된 클래스로
         * 사용시 연산의 결과를 Optional 객체에 담아서 반환한다.
         */
        // Optional 객체도 of()를 통해서 값을 넣을 수 있다.
        Optional<String> optional1 = Optional.of("안녕하세요");
        Optional<MyData> optional2 = Optional.of(myData);

        // Optional 객체는 기본적으로 null 체크에 강하다.
        try {
            Optional<String> optional3 = Optional.of(null);
        } catch (NullPointerException n) {
            System.out.println("만약 null값이 들어올 데이터면 ofNullable()를 이용하자.");
        }
        Optional<String> optional4 = Optional.ofNullable(null);

        /**
         * 값을 가져오기 위해서는 get()을 사용해야 한다.
         */
        // 꺼낼 객체의 타입에 잘 맞춰서 받아주자
        String text = optional1.get();
        MyData myData1 = optional2.get();

        /**
         * 그런데 만약 받아올 값이 null일 확률이 있는 객체일 경우에는
         * orElse() 또는 orElseThrow()를 통해서 처리가 가능하다.
         */
        // 내용을 null로 변경
        Optional<String> nullCheckOne = Optional.ofNullable("내용");

        String str = nullCheckOne.orElse("null 이라면 이것이 날라간다!");

        // orElseThrow()는 보이는 것처럼 예외를 바로 발생시켜버린다.
        try {
            String hateNull = nullCheckOne.orElseThrow(NullPointerException::new);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // orElseGet()은 Supplier 타입으로 값을 돌려주면 된다.
        String newOne = nullCheckOne.orElseGet(() -> {
           return "대체 값이얌";
        });

        /**
         * 그리고 전에 배웠던 filter()나 map()같은
         * 중간 연산을 Optional에 메서드 체이닝 가능하다.
         */
        // 스트림 파트는 보면볼수록 복잡하기는 하다
        int example = Optional.of("123").filter(ex -> ex.length() > 0).map(Integer::parseInt).orElse(-1);

        /**
         * 또 다른 null 확인 방법으로는 isPresent()와 ifPresent()가 있다.
         */
        String myText = "안녕??";
        Optional<String> optionalS1 = Optional.of(myText);
        Optional<String> optionalS2 = Optional.empty();

        if (optionalS1.isPresent()) {
            if (optionalS2.isPresent()) {
                System.out.println("isPresent()는 값이 있는지 확인을 하기 위한 용도이다.");
            } else {
                System.out.println("ifPresent()는 값이 있을 경우 실행하는 메서드이다.");
                optionalS1.ifPresent(System.out::println);
            }
        }

        // 응용릏 하면 이렇게 가능하다고 한다.
        // String myLoveWord = "Hello World";
        String myLoveWord = null;
        Optional.ofNullable(myLoveWord).ifPresent(System.out::println);

        /**
         * Optional에도 Stream과 같이 기본형을 지원하는 형태가 존재한다.
         * Stream과 같이 int, long, double 형태가 존재한다.
         */
        // 여기서는 int쪽을 살펴본다. 여기서 중요한 것은
        // 둘 다 값이 0이지만 취급의 차이가 다르다.
        OptionalInt optionalInt1 = OptionalInt.of(0);
        OptionalInt optionalInt2 = OptionalInt.empty();

        System.out.println(optionalInt1.isPresent());
        System.out.println(optionalInt2.isPresent());
        System.out.println(optionalInt1.equals(optionalInt2));

        // 값을 가져올 때는 getAsInt()를 이용해서 가져온다.
        System.out.println(optionalInt1.getAsInt());

        // 이처럼 실제로 값을 가져올 때는 값을 없는 취급해버린다.
        System.out.println(optionalInt2.getAsInt());

        /**
         * Optional에서는 empty()로 저장을 한다면 사실상 null을 저장하는 건데
         * 기본형 Optional은 취급이 조금 다르다는 것을 알 수 있다.
         * 이처럼 위에서 언급한 것처럼 Optional은 null 체크에 굉장히 유용하게
         * 탄생이 된 객체이다. 다만 단점도 존재하는데
         * 1. 비용이 좀 든다는 점이다. 왜냐하면 객체에 또 객체를 감싸서 다루기 때문이다.
         * 2, 필드값으로는 사용을 할 수 없다.
         * 3. 이래도 완벽한 null 방어는 당연히 불가능하다. (단점이라기에는 애매)
         * 이 외에도 단점들이 존재할 것이다. 하지만 그만큼 사용자의 null 체크를
         * 편하게 해주니 반가운 객체이다.
         */

    }

}

class MyData {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}