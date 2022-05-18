package level_02.java_chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림4
 * 이전에 스트림에 총 2가지의 연산 과정이 존재한다고 했다.
 * 그 중에 하나인 중간연산을 먼저 다뤄본다.
 * 중간연산은 최종연산을 가기전에 데이터를 가공하는 과정이라고 생각하자.
 */
public class Chap_12 {

    public static void main(String[] args) {
        List<String> strArr = new ArrayList<>();
        getString(strArr);

        /**
         * skip(long)은 스트림의 일부를 건너뛰는 기능이다.
         * limit(long)는 요소를 정해진 값만큼 제한한다.
         */
        // 해당 리스트의 값을 2번째까지 무시하고 한개만 보여줘
        Stream<String> test1 = strArr.stream().skip(2).limit(1);
        test1.forEachOrdered(System.out::println);

        /**
         * filter() 주어진 조건에 맞지 않는 요소 제거
         * distinct() 중복도니 요소를 제거한다.
         */
        IntStream intStream1 = IntStream.of(1, 1, 2, 3, 5, 5, 6, 6, 6, 4, 6, 5, 7, 9);

        // of()로 만들어진 스트림 값의 중복을 제거하고 4보다 미만인 값의 총 갯수를 반환하라
        int result = (int) intStream1.distinct().filter(number -> number < 4).count();
        System.out.println(result);

        // filter() 같은 경우는 응용할 곳이 많다.
        List<Integer> list = new ArrayList<>();
        makeNumber(list);
        Stream<Integer> integerStream = list.stream();

        // 30까지의 소수를 대애충 뽑아보면..
        integerStream.filter(i -> i % 2 != 0).filter(i -> i % 3 != 0).filter(i -> i % 5 != 0).forEachOrdered(System.out::println);

        /**
         * sorted()는 말그대로 스트림의 값을 정렬해준다.
         */
        IntStream intStream = IntStream.of(makeRandomNumber());
        intStream.sorted().forEachOrdered(System.out::println);

        // sorted()는 Comparator()를 이용하여 정렬하는데 따로 지정하지 않으면 스트림의 기본을 이용하여 정렬한다.
        // 해당 부분은 따로 조금 더 봐야하는 부분이다.

        /**
         * map()을 이용하여 특정한 값을 뽑거나 변환해야할 떄 사용을 한다.
         * peek()는 연산 사이에 사용하여 확인을 하는 용도로 많이 사용한다고 한다. 스트림을 소모하지 않는 특성이 있다.
         */
        String[] engArr = new String[]{"Hello", "hi", "world", "java"};
        Stream<String> stringStream1 = Arrays.stream(engArr);
        stringStream1.map(str -> str.concat(" script")).peek(System.out::println)
                .map(str -> str.charAt(0)).forEachOrdered(System.out::println);

        // peek()는 filter()나 map()의 연산에 넣어서
        // 과정을 보는 장점도 있지만 실행결과를 복잡하게 만드는 단점도 있다.

        /**
         * 기본형 스트림에는 sum(), average(), max(), min()과 같은
         * 연산결과를 돌려주는 최종연산이 존재한는데 해당 메서드들의 스트림의 종류는 모두 틀리다.
         * 이럴 때 스트림의 종류를 묶어주는 것이 바로 IntSummaryStatistics 클래스이다.
         */
        IntStream exampleStream = IntStream.of(1, 1, 2, 3, 5, 5, 6, 6, 6, 4, 6, 5, 7, 9);
        IntSummaryStatistics intSummaryStatistics = exampleStream.summaryStatistics();
        int sumResult = intSummaryStatistics.getMax();
        int minResult = intSummaryStatistics.getMin();
        // 이런식으로 편하게 기본형 최종 연산을 받을 수 있다.

        /**
         * flatMap()은 Stream<T[]>를 Stream<T>으로 변경해준다.
         */
        // 이러한 값을 가진 스트림을 만들어 보자.
        Stream<String[]> streamArr = Stream.of(
          new String[]{"a", "b", "c"},
          new String[]{"d", "e", "f"}
        );

        /** 
         * 위의 값을 Stream<String>으로 변경을 하려고 한다면 어떻게 해야할까?
         * 위에서 언급한것처럼 변환이니까 map()을 사용해보자.
         */
        // 확인하기 위해서 주석을 해제하자
        //Stream<Stream<String>> resultStream = streamArr.map(Arrays::stream);

        /**
         * 이럴때 배열을 해제해서 넣어주는 값인 flatMap()이 필요하다. 
         */
         Stream<String> resultStream = streamArr.flatMap(Arrays::stream);
        // 간단하게 배열타입을 사용할 때 일반타입으로 돌려줄 때 쓴다고 생각하자


    }

    static void getString(List<String> list) {
        for (int i = 0; i < 5; i++) {
            String text = i + 1 + "번째 글!";
            list.add(i, text);
        }
    }

    static void makeNumber(List<Integer> list) {
        for (int i = 1; i < 30; i++) {
            list.add(i);
        }
    }

    static int[] makeRandomNumber() {
        int[] intArr = new int[10];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = (int) (Math.random() * 100 + 1);
        }
        return intArr;
    }

}
