package level_02.java_chap02;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 스트림3
 * 우선적으로 스트림을 사용하기 위해서는 스트림을 생성해야 한다.
 * 다양한 스트림 생성 방법에 대해서 알아보자
 */
public class Chap_11 {
    public static void main(String[] args) {
        /**
         * 컬렉션에서의 스트림
         * Collection을 구현하는 객체들은
         * 모두 Stream으로 구현할 수 있도록 미리 정의가 되어있다.
         */
        List<String> list = new ArrayList<>();
        Stream<?> collection = list.stream();

        Set<Object> set = new HashSet<>();
        Stream<Object> stream = set.stream();

        /** 
         * 배열에서의 스트림
         * 배열을 소스로 하는 스트림을 생성하는 메서드는
         * 스트림과 Arrays에 정의가 되어있다.
         */
        // of()를 통해서 스트림값을 지정하여 만들 수 있다.
        Stream<?> streamEx = Stream.of("a","b","c");

        // Arrays.stream()을 이용하여 배열을 변경가능
        Stream<?> streamArr = Arrays.stream(new Integer[]{1, 2, 3});

        /**
         * 위의 예시처럼 int, long, double 같은 기본형을 사용하는 스트림을 사용을 한다면
         * 자바에서 제공하는 intStream, LongStream 같은 타입을 사용하면 성능상에서도 이점을 챙길 수 있다.
         */
        LongStream longStream = LongStream.of(1, 2, 3, 4, 5);

        /**
         * 기본형타입을 다루는 스트림은 기존의 스트림에는 없는 메서드도 제공한다.
         */
        // range()와 rangeClosed()는 범위를 지정하여 숫자를 다룬다, Closed는 끝의 범위도 포함한다.
        LongStream longStream1 = LongStream.range(1, 10); // 1 ~ 9

        /**
         * 그리고 Random 클래스에도 난수를 생성하는 스트림이 정의가 되어있다.
         * 주의할 점은 해당 스트림들은 무한 스트림으로써 크기를 제한을 해줘야 한다는 점이다.
         */
        IntStream intStream = new Random().ints();
        // intStream.forEachOrdered(System.out::println); // 이렇게 사용하면 계속해서 수를 생성한다.

        // 그래서 limit()를 사용해서 일부를 잘라내서 사용을 하는식으로 해야한다.
        intStream.limit(10).forEach(System.out::println);

        // 이 방법을 한 줄로 표현하면 이렇게 된다.
        DoubleStream doubleStream = new Random().doubles(10); // 10개의 요소만 가져온다.
        doubleStream.forEachOrdered(d -> {
            System.out.println(d * 100);
        });

        /**
         * 위의 방버말고도 무한 스트림을 생성하는 방법이 존재하는데
         * iterate()와 generate()이다.
         */
        // iterate()는 씨앗값으로 지정된 값부터 시작하여 람다식으로 계산된 결과를 씨앗값으로 해서 계산을 반복한다.
        Stream<Integer> seedStream = Stream.iterate(1, number ->
            number * 10
        );
        seedStream.limit(10).forEachOrdered(System.out::println);

        // generate()는 iterate()와 달리 supplier를 파라미터로 쓰기 때문에 파라미터 한개만 넣을 수 있다.
        Stream<Double> doubleStreamEx = Stream.generate(Math::random);
        doubleStreamEx.limit(10).forEachOrdered(System.out::println);

        /**
         * 이런 스트림을 자바에서 제공하는 FIle 메서드를 다루는데 유용하게 사용할 수 있다고 한다.
         * 바로 list()를 이용해서 한다고 한다. 현재 주제에는 맞지 않지만 스트림을 이런식으로
         * 사용을 한다는것만 알고가자
         */
        // Stream<Path> pathStream = Files.list(Path) 이런식으로 사용을 한다고 한다.

        /**
         * 마지막으로 빈 스트림도 생성이 가능하다. 만약 스트림의 연산 결과가 없을 때
         * null 값보다는 당연하게도 빈 스트림을 반환하는 것이 좋다.
         */
        Stream<?> emptyStream = Stream.empty();
        System.out.println("empty()");
        emptyStream.forEachOrdered(System.out::println); // 예상대로 아무런 값도 나오지 않음

        /**
         * 끝으로 같은 타입의 스트림일 경우에는 두 요소를 합칠수도 있다.
         */
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{4,5,6};
        IntStream intStream1 = Arrays.stream(arr1);
        IntStream intStream2 = Arrays.stream(arr2);
        IntStream intStream3 = IntStream.concat(intStream1, intStream2);
        intStream3.distinct().forEachOrdered(System.out::println);

        /**
         * 이런식으로 다양하게 스트림을 생성을 할 수 있다는 것을 알것이다.
         * 늘 상황에 맞춰서 스트림을 생성을 하면 좋다. 또한 스트림의 단순하면서
         * 강력한 성능만 보고 무작정 스트림만 사용은 하면 오히려 가독성이 떨어지는 상황이 벌어진다.
         */
    }
}
