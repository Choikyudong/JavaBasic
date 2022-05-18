package level_02.java_chap02;

import java.util.function.*;

// 람다식(Lambda expression)

public class Chap_08 {

    // 기본적인 함수형 인터페이스들을 사용해보자.
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "안녕하세요";
        System.out.println(supplier.get());

        // .get()으로 supplier의 값에 접근할 수 있다.
        String str = supplier.get();

        Consumer<String> consumer = (string) -> {
            char ch = string.charAt(0);
            System.out.println(ch);
        };

        // .accept()로 consumer를 실행시킬 수 있다.
        consumer.accept(str);

        Predicate<String> predicate = (string) -> string.equals("안녕하세요");

        // .test()로 실행
        System.out.println(predicate.test(str));

        Function<String, String> function = (string) -> {
            if (string.equals("안녕하세요")) {
                return "반갑습니다";
            }
            return "이건 뭐지?";
        };
        System.out.println(function.apply(supplier.get()));

        //합성과 결합
        //두 개의 함수형 인터페이스를 합성하여 사용을 할 수 있다.
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
        Function<String, String> h = f.andThen(g);

        // 이런식으로 andThen()같은 문구로 결합이 가능하다.
        // 또 Predicate를 결합하면 이런식도 가능하다.
        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i %2 == 0;
        Predicate<Integer> notP = p.negate(); // ! 연산자와 같다.

        Predicate<Integer> all = notP.and(q.or(r)); // and 연산자와 or 연사자이다.
        System.out.println(all.test(150));

        // 메서드 참조
        // 람다식을 조금 더 줄일 수 있는 방법으로
        // 하나의 메서드만 호출하는 경우에는 메서드 참조라는 방법으로 람다식을 간략히 할 수 있다.

        // 이러한 람다가 있다.
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);

        // 위의 람다식은 문자를 그저 래퍼클래스에 집어넣어서 변형시키는 것이 전부인 식이다.
        // 그리고 위의 식을 조금 더 풀어서 보면 이런 느낌이다.
        /*
         *  Integer 이름 (String s) {
         *      return Integer.passerInt(s);
         *  }
         *
         * 이런 느낌의 식일 것이다.
         */
        
        // 보이는 것처럼 불필요한 메서드를 버리고 parseInt()를 직접 호출하는 것은 어떨까
        Function<String, Integer> f2 = Integer::parseInt; // 메서드 참조

        // 컴파일러는 우변의 parseInt 부분을 참고하여 실행을 시킨다.

        // 이런식도 변경이 가능하다.
        BiFunction<String, String, Boolean> f3 = (s1, s2) -> s1.equals(s2);

        BiFunction<String, String, Boolean> f4 = String::equals;

        // 정리를 하면 하나의 메서드만 호출하는 람다식은
        // "클래스이름::메서드이름" 또는 "참조변수::메서드이름"으로 변경이 가능하다.
        // 그리고 생성자의 메서드 참조도 가능하다.
        Supplier<Chap_08> s1 = () -> new Chap_08(); // 기존의 람다식으로 인스턴스 생성
        Supplier<Chap_08> s2 = Chap_08::new; // 메서드 참조

        // 매개변수가 있는 생성자라면
        Function<Integer, Con_1> bf = Con_1::new;

        // 배열을 생성한다면
        Function<Integer, int[]> fa = int[]::new;

        /*
            람다식은 정말로 많이 해봐야 알 수 있는 부분이고 다시봐도 어렵고
            이렇게 봐도 어렵다 하지만 그만큼 익혀두면 코드에 많은 변화를 줄 수 있으니
            한번쯤은 꼭 익혀보면 좋다.
         */
    }

}

class Con_1 {
    int number;
    Con_1 (int number) {
        this.number = number;
    }
}
