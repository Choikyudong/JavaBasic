package level_02.java_chap02;

import java.util.*;
import java.util.function.*;

// 람다식(Lambda expression)

// java.util.function 패키지에는 함수형 인터페이스를 힘들게 만들 사람들을 고려해서
// 기본적으로 제작이 되어있으니 이것을 이용해보는 것도 좋은 방법이라고 생각한다.
// 여기서는 자주 사용되는 인터페이스들을 살펴본다.
// <T>를 보고 당황한다면 지네릭스부분을 다시 참고하고 오면 좋을 듯 하다.
public class Chap_07 {

    /*자주 사용되는 기본적인 함수형 인터페이스*/
    // 여기서 T는 "Type"을 말한다.

    /*Supplier<T>*/
    // 매개변수없이 반환값만 존재한다.
    Supplier supplier = new Supplier() {
        @Override
        public Object get() {
            return null;
        }
    };

    /*Consumer<T>*/
    // 매개변수는 있으나 반환값은 없다.
    Consumer consumer = new Consumer() {
        @Override
        public void accept(Object o) {
            // return 어디감?
        }
    };

    /*Function<T, R>*/
    // 매개변수를 하나받고 그 값을 돌려준다. 여기서 R은 "Return Type"을 의미한다고 한다.
    Function function = new Function() {
        @Override
        public Object apply(Object o) {
            return null;
        }
    };

    /*Predicate<T>*/
    // 조건식에 많이 사용되며, 매개변수는 하나이며 반환타입이 "boolean"이다.
    Predicate predicate = new Predicate() {
        @Override
        public boolean test(Object o) {
            return false;
        }
    };

    /*매개변수가 2개인 함수형 인터페이스*/
    /*BiConsumer<T, U>*/
    // Consumer에서 매개변수가 하나 더 추가되었다. 여기서 U는 정말 아무의미없이 T의 다음 문자라서 채택이 되었다;
    BiConsumer biConsumer = new BiConsumer() {
        @Override
        public void accept(Object o, Object o2) {
            
        }
    };

    /*BiPredicate<T, U>*/
    // Predicate에서 매개변수가 하나 더 추가되었음 당연히 반환값은 "boolean"이다.
    BiPredicate biPredicate = new BiPredicate() {
        @Override
        public boolean test(Object o, Object o2) {
            return false;
        }
    };

    /*BiFunction<T,U,R>*/
    // 두 개의 매개변수를 받아서 "하나의 결과"를 반환
    BiFunction biFunction = new BiFunction() {
        @Override
        public Object apply(Object o, Object o2) {
            return null;
        }
    };

    // Supplier는 반환값만 존재하는 인터페이스인데, 두 개의 값을 반환을 못하므로 BiSupplier는 없다.
    // 3개 이상의 매개변수를 갖는 인터페이스는 직접 정의를 해야 한다.

    // Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있는데
    // 매개변수의 타입과 반환타입의 타입이 모두 일치한다는 것만 제외하고는 Function과 같다.

    /*UnaryOperator<T>*/
    // Function의 자손으로 매개변수와 결과의 "타입"이 같다.
    UnaryOperator unaryOperator = new UnaryOperator() {
        @Override
        public Object apply(Object o) {
            return null;
        }
    };

    /*BinaryOperator<T>*/
    // BiFunction의 자손으로 매개변수와 결과의 타입이 같다.
    BinaryOperator binaryOperator = new BinaryOperator() {
        @Override
        public Object apply(Object o, Object o2) {
            return null;
        }
    };

    // 앞에서 먼저 학습한 컬렉션프레임워크에도 함수형 인터페이스를 결합한 것들이 있다.
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        /*
            인터페이스 : Collection
            메서드 : boolean removeIf(Predicate<E> filter)
            설명 : 조건에 맞는 요소를 샂게
         */
        // 기존의 Predicate는 매개변수가 필요하며 반환값은 boolean타입이다.
        // 2로 나누어 떨어지는 수를 제거하도록 설정을 했다.
        list.removeIf((number) -> number % 2 == 0);

        /*
            인터페이스 : List
            메서드 : void replaceAll(UnaryOperator<E> operator)
            설명 : 모든 요소를 변환하여 대체
         */
        // UnaryOperator은 매개변수의 결과와 타입이 같다.
        // 모든 값에 1을 더해보자.
        list.replaceAll((number) -> number + 1);

        /*
            인터페이스 : Iterable
            메서드 : void forEach(Consumer<T> action)
            설명 : 모든 요소에 작업(action)을 수행한다.
         */
        // Consumer는 매개변수는 있고 반환타입이 없다.
        // 모든 문장을 간단하게 출력하자.
        list.forEach(number -> System.out.print(number + " "));

        Map<Integer, Integer> map  = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        
        /*
            인터페이스 : Map
            메서드 : V compute(K key, BiFunction<K,V,V> f)
            설명 : 지정된 키의 값에 작업 f를 수행
         */
        // BiFunction은 2개이상의 매개변수에 하나의 결과를 리턴
        map.compute(1, (key, value) -> value * 5);
        
        /*
            인터페이스 : Map
            메서드 : V computeIfAbsent(K key, Function<K,V> f)
            설명 : 지정된 키가 없다면, 작업 f 후에 추가
         */
        map.computeIfAbsent(6, (value) -> value = map.get(1));

        // 추가로 putIfAbsent가 비슷하다.
        // 7이라는 키값이 없다면 7이라는 값을 넣어서 Map을 만드는 메서드이다.
        map.putIfAbsent(7, 7);
        
        /*
            인터페이스 : Map
            메서드 : V computeIfPresent(K key, BiFunction<K,V,V> f)
            설명 : 지정된 키가 있다면, 작업 f를 수행
         */
        map.computeIfPresent(7, (key, value) -> value = 10);

        /*
            인터페이스 : Map
            메서드 : V merge(K key,V value, BiFunction<V,V,V> f)
            설명 : 모든 요소에 병합작업 f를 실행
         */
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Hi");
        map1.put(2, "Hello");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "안녕하세요");
        map2.put(2, "반갑습니다.");

        // merge 같은 경우에는 forEach와 같이 사용한다. 위의 forEach와 같다.
        map2.forEach((key, value) -> map1.merge(key, value,(value1, value2) -> value1 + " " + value2));

        // 출력 결과
        System.out.println("\n" + map1);

        /*
            모든 예시에서는 Wrapper 클래스들을 주로 사용했는데
            기본형 타입들을 이용한 인터페이스들도 존재한다.
        */

        // 입력이 A타입 출력이 B타입인 인터페이스
        DoubleToIntFunction doubleToIntFunction = new DoubleToIntFunction() {
            @Override
            public int applyAsInt(double value) {
                return 0;
            }
        };

        // 입력은 제네릭 타입이고 출력은 기본형이다.
        ToIntFunction toIntFunction = new ToIntFunction() {
            @Override
            public int applyAsInt(Object value) {
                return 0;
            }
        };

        // 입력은 기본형 출력은 제네릭타입이다.
        IntFunction intFunction = new IntFunction() {
            @Override
            public Object apply(int value) {
                return null;
            }
        };

        // 입력은 제네릭 또는 기본형이며 출력은 없다.
        ObjIntConsumer objIntConsumer = new ObjIntConsumer() {
            @Override
            public void accept(Object o, int value) {

            }
        };

    }

}
