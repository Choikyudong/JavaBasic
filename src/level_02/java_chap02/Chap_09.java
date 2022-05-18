package level_02.java_chap02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 스트림(stream)
 *
 * 우선적으로 기존에 배열, 컬렉션같은 많은 수의 데이터를 다룰 때에는
 * for, Iterator와 같은 코드를 이용했는데 이러한 코드가 길고 알아보기가 힏들다는 점이 있었다.
 * 덤으로 재사용성도 떨어진다.
 *
 * 다른 문제는 데이터 소스마다 다른 방식으로 다뤄야 한다는 점인데
 * Iterator와 같은 인터페이스로 컬렉션의 반복을 표준화 하였으나
 *
 * List나 배열을 정렬을 할 때에는 Collection.sort를 사용하거나 Arrays.sort를 사용하는 등
 * 같은 기능이지만 중복이 되어있다.
 *
 * 이러한 문제점을 해결하기 위한 것이 스트림이다.
 * 데이터 소스를 추상화하고 자주 사용하는 메서드를 정의해 두었다.
 *
 * 데이터 소스를 추상화하여서 소스 종류와는 무관하게 같은 방식으로 다룰 수 있고
 * 코드의 재사용성도 증가가 되었다.
 *
 * 스트림은 배열뿐만 아니라 파일을 읽을 때에도 사용하는 등 다양하게 사용이 가능하다.
 */

public class Chap_09 {

    public static void main(String[] args) {
        /**
         * 이러한 배열이 있다고 가정을 한다.
         */
        String[] strArr = {"aaa", "ddd", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        System.out.println("stream start");
        /**
         *  여기서 스트림을 생성해보면
         */
        Stream<String> stream1 = Arrays.stream(strArr);
        Stream<String> stream2 = strList.stream();

        /**
         * 이제 스트림을 이용해서 출력을 해보자
         */
        stream1.sorted().forEach(System.out::println);
        stream2.sorted().forEach(System.out::println);
        System.out.println("stream end");


        /**
         * 생각보다 쉽고 편하게 원하는 값을 출력할 수 있었다.
         * 그렇다면 스트림없이 각각의 결과를 출력을 해보자.
         */

        System.out.println("normal start");
        // .sorted() 부분
        Arrays.sort(strArr);
        Collections.sort(strList);

        // .forEach() 부분
        for (String str : strArr) {
            System.out.println(str);
        }
        for (String str : strList) {
            System.out.println(str);
        }
        System.out.println("normal end");

        /**
         * 이런 복잡한 과정을 스트림 저 한줄로 통일성있게 사용을 할 수 있다.
         * 또한 디버깅을 해보면 스트림의 결과는 원본 소스에는 영향을 주지 않는것을 알 수 있다.
         */
        // 만약 원한다면 데이터를 받아서 사용하면 된다.
        Stream<String> stream3 = strList.stream();
        List<String> strings = stream3.sorted().collect(Collectors.toList());
        System.out.println(strings);

        // 주의할 점은 스트림은 "재사용"이 불가능하다는 점
        try {
            List<String> stringList = stream3.sorted().collect(Collectors.toList());;
        } catch (IllegalStateException i) {
            System.out.println("에러 발생!");
        }

        /**
         *
         * 스트림의 작업방식은 내부 반복이다. 그렇기에 작업이 간결하다.
         * 내부반복은 반복문을 메서드의 내부에 숨기는 것을 의미한다.
         *
         * 내부 모습은 이러한 모습이라고 한다.
         *  void forEach(Consumer<? super T> action) {
         *      Objects.requireNonNull(action); // 널 체크
         *
         *      for(T t : src) {
         *          action.accept(T);
         *      }
         *  }
         *
         */
    }

}
