package level_02.java_chap02;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.*;

/**
 * 스트림2
 * 스트림은 크게 2가지 과정이 있는데 중간 연산과 최종 연산이다.
 * 중간 연산은 연산결과를 "스트림"으로 반환해서 중간 연산을 연속해서 연결할 수 있는데 (메서드 체이닝처럼)
 * 최종 연산은 스트림의 요소를 "소모"하기 때문에 단 한번만 사용이 가능하다.
 */
public class Chap_10 {

    /**
     * 여기서는 가볍게 스트림에 대해서 알아보는 시간이다.
     */
    public static void main(String[] args) {
        Stream<?> stream = new Stream<Object>() {
            /** 
             * 조건에 안 맞는 요소를 제외하는 기능
             */
            @Override
            public Stream<Object> filter(Predicate<? super Object> predicate) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public <R> Stream<R> map(Function<? super Object, ? extends R> mapper) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public IntStream mapToInt(ToIntFunction<? super Object> mapper) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public LongStream mapToLong(ToLongFunction<? super Object> mapper) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public DoubleStream mapToDouble(ToDoubleFunction<? super Object> mapper) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public <R> Stream<R> flatMap(Function<? super Object, ? extends Stream<? extends R>> mapper) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public IntStream flatMapToInt(Function<? super Object, ? extends IntStream> mapper) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public LongStream flatMapToLong(Function<? super Object, ? extends LongStream> mapper) {
                return null;
            }

            /**
             * 중간연산으로 스트림의 요소를 변환한다.
             */
            @Override
            public DoubleStream flatMapToDouble(Function<? super Object, ? extends DoubleStream> mapper) {
                return null;
            }

            /** 
             * 중복을 제거한다.
             */
            @Override
            public Stream<Object> distinct() {
                return null;
            }

            /** 
             * 스트림의 요소를 정렬
             */
            @Override
            public Stream<Object> sorted() {
                return null;
            }

            /** 
             * 스트림의 요소를 정렬
             */
            @Override
            public Stream<Object> sorted(Comparator<? super Object> comparator) {
                return null;
            }

            /**
             *  스트림의 요소에 작업 수행
             */
            @Override
            public Stream<Object> peek(Consumer<? super Object> action) {
                return null;
            }

            /**
             * 스트림의 일부를 잘라낸다.
             */
            @Override
            public Stream<Object> limit(long maxSize) {
                return null;
            }

            /**
             * 스트림의 일부를 건너뛴다.
             */
            @Override
            public Stream<Object> skip(long n) {
                return null;
            }

            /**
             * 최종 연산
             * 각 요소에 지정된 작업 수행
             */
            @Override
            public void forEach(Consumer<? super Object> action) {

            }

            /**
             * 최종 연산
             * forEach와 비슷한 기능이지만 
             * 병렬 스트림과 동기화면에서 좀 더 직관적이고 효과적으로 사용이 가능하며
             * 많은 사람들은 해당 foreEach보다는 해당 메서드를 권장한다.
             */
            @Override
            public void forEachOrdered(Consumer<? super Object> action) {

            }

            /**
             * 최종 연산
             * 스트림의 모든 요소를 배열로 반환한다.
             */
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            /**
             * 최종 연산
             * 스트림의 모든 요소를 배열로 반환한다.
             */
            @Override
            public <A> A[] toArray(IntFunction<A[]> generator) {
                return null;
            }

            /**
             * 최종 연산
             * 요소를 줄여가며 하나씩 계산한다.
             */
            @Override
            public Object reduce(Object identity, BinaryOperator<Object> accumulator) {
                return null;
            }

            @Override
            public Optional<Object> reduce(BinaryOperator<Object> accumulator) {
                return Optional.empty();
            }

            @Override
            public <U> U reduce(U identity, BiFunction<U, ? super Object, U> accumulator, BinaryOperator<U> combiner) {
                return null;
            }

            /**
             * 최종 연산
             * 스트림의 요소를 수집한다.
             * 요소를 그룹화하거나 분한할 결과를 컬렉션에 반환하는데 사용한다.
             */
            @Override
            public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super Object> accumulator, BiConsumer<R, R> combiner) {
                return null;
            }

            @Override
            public <R, A> R collect(Collector<? super Object, A, R> collector) {
                return null;
            }

            /**
             * 최종 연산
             * 스트림의 최소값을 반환
             */
            @Override
            public Optional<Object> min(Comparator<? super Object> comparator) {
                return Optional.empty();
            }

            /**
             * 최종 연산
             * 스트림의 최대값을 반환
             */
            @Override
            public Optional<Object> max(Comparator<? super Object> comparator) {
                return Optional.empty();
            }

            /**
             * 스트림의 요소 개수를 반환
             */
            @Override
            public long count() {
                return 0;
            }

            /**
             * 주어진 조건 중 하나라도 만족하는지
             */
            @Override
            public boolean anyMatch(Predicate<? super Object> predicate) {
                return false;
            }

            /**
             * 주어진 조건 중 모든게 만족하는지
             */
            @Override
            public boolean allMatch(Predicate<? super Object> predicate) {
                return false;
            }

            /**
             * 주어진 조건 중 모두 만족하지 않을 경우
             */
            @Override
            public boolean noneMatch(Predicate<? super Object> predicate) {
                return false;
            }

            /** 
             * 조건에 일치하는 요소 중 가장 먼저 발견이 되는것을 반환
             */
            @Override
            public Optional<Object> findFirst() {
                return Optional.empty();
            }

            /**
             * 조건에 일치하는 요소 중 일치하는 요소 1개를 리턴합니다.
             * findFirst와의 차이점은 병렬로 처리할 경우에
             * First()는 여러값이 일치해도 항상 가장 앞의 요소를 리턴
             * Any()는 멀티쓰레드 환경에서 가장 먼저 찾은 요소를 찾는데
             * 일정한 값을 찾는것이 아닌 실행할 때마다 리턴값이 달리진다고 하는데?
             */
            @Override
            public Optional<Object> findAny() {
                return Optional.empty();
            }

            @Override
            public Iterator<Object> iterator() {
                return null;
            }

            @Override
            public Spliterator<Object> spliterator() {
                return null;
            }

            @Override
            public boolean isParallel() {
                return false;
            }

            /** 
             * 병렬 처리를 수행하지 않도록 만드는 메서드
             */
            @Override
            public Stream<Object> sequential() {
                return null;
            }

            /**
             * 스트림의 장점 중 하나로써 자동으로 연산을 병렬로 수행하게 만든다.
             */
            @Override
            public Stream<Object> parallel() {
                return null;
            }

            @Override
            public Stream<Object> unordered() {
                return null;
            }

            @Override
            public Stream<Object> onClose(Runnable closeHandler) {
                return null;
            }

            @Override
            public void close() {

            }

            /**
             * 여기서는 중간연산과 최종연산에 대하여 학습을 했는데
             * 중요한것은 최종연산을 할 경우에는 스트림을 소모하게 되면서
             * 스트림을 다시 생성을 해야한다.
             * 다만 여기서 주의를 해야하는 것은 스트림을 소모를 하는것이지
             * 데이터 소스가 소모되는 것은 아니라는 것이다.
             */

        };
    }

}
