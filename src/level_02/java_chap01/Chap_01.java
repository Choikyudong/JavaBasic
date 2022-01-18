package level_02.java_chap01;

import java.util.Collection;
import java.util.Iterator;

// 이제 기초적인 단계를 완료하고 조금 더 심화적인 내용을 다룬다.

/*자바와 컬렉션프레임워크*/
// 우선 프레임워크란 무언가를 만들 떄 기초적인 골격, 설계도라고 생각을 하자
// 그러면 컬렉션프레임워크라는 것은 데이터들을 다루기 위해 만들어 둔 설계도라고 이해하면 된다.
public class Chap_01 {

    /*
    *  Collection이라는 인터페이스에서 부터 시작된다.
    *  그리고 컬렉션에서 3가지로 또 나누어진다.
    *  List : 순서가 있는 데이터의 집합, 중복을 허용한다.
    *  Set : 순서를 유지하지 않는 데이터의 집합, 중복을 허용안한다.
    *  Map : 키와 값으로 이루어진 데이터의 집합이며 순서는 유지하지 않고 키의 중복은 허용안하지만 값의 중복은 허용한다.
    *
    *  Map은 컬렉션 프레임워크에 속해있지만 List, Set과는 구성이 많이 다르다.
    *  그래서 Map과 Collection은 같은 컬렉션 프레임워크이지만 같은 상속계층에는 포함이 되지 않는다.
    */

    /*우선 여기서는 공통적인 인터페이스인 Collection을 살펴보자*/
    public static void main(String[] args) {
        // 파악을 하기 위해서 인터페이스를 이렇게 구현을 하였다.
        // 실제로는 이렇게는 사용을 안한다.. 공부용으로만 봐야한다.
        Collection collection = new Collection() {
            // 컬렉션에 저장된 "객체의 개수"를 반환, 컬렉션의 길이를 말하는 것이 아니다.
            @Override
            public int size() {
                return 0;
            }

            // 컬렉션이 비어있는지 확인한다.
            @Override
            public boolean isEmpty() {
                return false;
            }

            // 지정한 객체가 존재하는지 확인한다.
            @Override
            public boolean contains(Object o) {
                return false;
            }

            // Iterator를 얻어서 반환한다.
            // 간단하게 설명하면 Iterator는 컬렉션프레임워크에서 저장된 요소들을 읽어오는 방법을 표준화한 것이다.
            @Override
            public Iterator iterator() {
                return null;
            }

            // 저장된 객체를 "객체배열"로 반환한다.
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            // 지정된 배열에 "컬렉션 객체"를 저장해서 반환한다.
            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            // 지정된 객체를 컬렉션에 추가한다.
            @Override
            public boolean add(Object o) {
                return false;
            }

            // 지정된 객체를 컬렉션에서 제거한다.
            @Override
            public boolean remove(Object o) {
                return false;
            }

            // contains가 비슷하지만 다른것은 파라티럴 보면 알듯이
            // 컬렉션 객체들이 포함이 되어있는지 확인한다.
            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            // add와 비슷하지만 위의 메서드처럼
            // 컬렉션 객체들을 컬렉션에 추가해주는 것이 다르다.
            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            // 역시 remove와 비슷하지만
            // 컬렉션에 포함된 객체들을 삭제한다.
            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            // 지정된 "컬렉션"만 남기고 다른 객체들을 컬렉션에서 삭제한다.
            // 해당 메서드로 컬렉션에 변화가 있다면 true, 없다면 false를 반환한다.
            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            // 컬렉션의 모든 객체를 삭제한다.
            @Override
            public void clear() {

            }

        };

        // JavaAPI 문서를 살펴보면 <E>라는 표시를 볼 수 있는데
        // 1.5버전 부터 추가된 제네릭에 의한 표기이다. E타입을 받는 객체라는 뜻으로 해석을 하자.
        // 그리고 여기서 E는 특정한 객체를 가르키는 것이 아닌 임의의 객체를 가르키는 것으로
        // 컬렉션에서는 E를 Object라고 생각을 하고 이해하면 조금 더 편할 것이다.
    }

}
