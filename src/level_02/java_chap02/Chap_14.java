package level_02.java_chap02;

import java.util.*;
import java.util.stream.Stream;

/**
 * 스트림6
 * 분량이 굉장히 많은데 거의 끝나간다.
 * 이제는 최종 연산에 대해서 알아보자.
 * 최종 연산은 스트림을 소모하여 결과를 만들어내는 과정을 말한다.
 */
public class Chap_14 {

    public static void main(String[] args) {
        List<Integer> example = makeRandom();

        /*
         * forEach()와 forEachOrdered()는 요소를 이용해서 반복작업을 한다.
         */
        Stream<Integer> stream = example.stream();
        stream.forEachOrdered(System.out::println);

        /*
         * 조건을 검사하는 allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
         * 스트림의 요소에 대해 지정된 조건에 만족하는지 확인하는데 사용하는 메셔드들이다.
         * 해당하는 메서드들은 Predicate를 이용한다.
         */
        Stream<Integer> match1 = example.stream();
        Stream<Integer> match2 = example.stream();
        Stream<Integer> match3 = example.stream();
        Stream<Integer> match4 = example.stream();
        Stream<Integer> match5 = example.stream();

        // anyMatch()는 하나라도 만족하면 된다.
        Boolean answer1 = (Boolean) match1.anyMatch(number -> number < 80);
        printSomething(answer1);

        // allMatch()는 모두 만족해야한다.
        Boolean answer2 = match2.allMatch(number -> 30 < number);
        printSomething(answer2);

        // noneMatch()는 모두 만족하지 말아야 한다.
        Boolean answer3 = match3.noneMatch(number -> number < 10);
        printSomething(answer3);

        // findFirst()는 첫 번째 요소를 찾는 메서드이다. 주로 필터와 같이 사용한다.
        Optional<?> answer4 = match4.findFirst();
        printSomething(answer4);

        // findAny()는 findFirst()와 비슷하나 병렬스트림일 때 주로 First()대신에 사용한다.
        Optional<?> answer5 = match5.findAny();
        printSomething(answer5);
        /* find..()들은 값이 없다면 비어있는 Optional 객체를 반환한다. */

       /**
        * 통계정보를 주는 최종 연산들
        * count(), sum(), average(), max(), min()
        */
        Stream<Integer> result1 = example.stream();
        // count()로 해당 스트림의 요소의 개수를 반환받을 수 있다.
        long count = result1.count();
        System.out.println(count);

        // max()와 min() 둘 다 Comparator를 이용한다.
        Stream<Integer> result2 = example.stream();
        Stream<Integer> result2_1 = example.stream();
        Stream<Integer> result3 = example.stream();
        Stream<Integer> result3_1 = example.stream();
        Stream<Integer> result4 = example.stream();
        Stream<Integer> result4_1 = example.stream();

        // mapToInt()로 int 형 으로 변형한다. 많이들 이런 방식을 채택하는 듯?
        OptionalInt maxNumber1 = result2.mapToInt(number -> number).max();
        System.out.println(maxNumber1);

        // Comparator를 이용하면 이런식으로 가능
        Integer maxNumber1_1 = result2_1.max(Comparator.comparing(number -> number))
                .orElseThrow(NoSuchElementException::new);

        // 이번에는 그냥 double 타입으로 해봄
        OptionalDouble minNumber1 = result3.mapToDouble(number -> number).min();
        System.out.println(minNumber1);

        // Comparator로는 이런 느낌, naturalOrder()로 기본적으로 정의가 되어진식으로 해결이 가능
        Optional<Integer> minNumber1_1 = result3_1.min(Comparator.naturalOrder());
        System.out.println(minNumber1_1);

        // sum()으로 간단하게 배열의 더해진 값들도 볼 수 있다. 반환값은 int
        int sum = result4.mapToInt(number -> number).sum();
        System.out.println(sum);

        // 간단하게 평균값을 얻을 수 있다. 반환값은 OptionalDouble
        OptionalDouble average = result4_1.mapToDouble(number -> number).average();
        System.out.println(average);

        /**
         * 가장 많이 사용하는 최종연산 중 하나인 reduce() 부분은 잘 봐두면 좋다고 한다.
         * 매개변수 타입은 BinaryOperator이다.
         * 스트림의 요소를 소모해가면서 진행을 하는 방식이다.
         */

        /*
         밑에서 사용하는 reduce()들은 초기값을 갖는 형태이다. 이렇게 지정하면
         초기값과 스트림의 첫 번째 요소로 연산을 시작한다.
         만약 스트림의 요소가없다면 초기값을 반환한다.
        */

        // reduce()는 count()와 sum() 등에서 내부적으로 사용한다고 한다. 밑은 count()를 구현한 모습
        int sout1 = example.stream().mapToInt(i -> i).reduce(0, (a, b) -> a + 1);
        System.out.println(sout1);

        // sum()
        int sout2 = example.stream().mapToInt(i -> i).reduce(0, (a, b) -> a + b);
        System.out.println(sout2);

        // max()
        int sout3 = example.stream().mapToInt(i -> i).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println(sout3);

        // min()
        int sout4 = example.stream().mapToInt(i -> i).reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a);
        System.out.println(sout4);

    }

    static List<Integer> makeRandom() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100) + 1);
        }
        return list;
    }

    static void printSomething(Object obj) {
        var data = obj;
        System.out.println(data);
    }

}
