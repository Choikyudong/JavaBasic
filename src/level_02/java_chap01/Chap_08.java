package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// Iterator 살펴보기
// 여기서는 계속해서 언급되는 Iterator와 ListIterator, Enumeration을 알아본다.
public class Chap_08 {

    // Iterator는 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화하였다.
    // Collection에 보면 Iterator를 반환하는 iterator()이 있다. (라인 266)
    // iterator()는 Collection에 정의된 메서드로 List, Set에도 알맞게 Iterator가 정의되어 있다.
    public static void main(String[] args) {
        /*Iterator*/
        Collection<String> c = new ArrayList<>();
        c.add("객체1");
        c.add("객체2");
        c.add("객체3");

        System.out.println("현재 컬렉션 -> " + c);

        // 이렇게 받으면 된다.
        Iterator<String> iterator = c.iterator();

        // 주로 while문을 이용해서 컬렉션 클래스들의 요소를 읽어 온다고 한다.
        // hasNext()로 읽어올 요소가 있는지 확인한다. 없다면 false를 반환한다.
        while (iterator.hasNext()) {

            // 반환타입이 "Object"인 메서드로 다음 요소를 읽어오는 기능이다.
            System.out.println(iterator.next());

            // next()로 읽은 다음에 해당 요소를 삭제한다. 선택적인 기능이다. (주석 처리를 하면서 비교해보자)
            iterator.remove();

        }

        System.out.println("현재 컬렉션 -> " + c);

        // Map은 직접적으로 Iterator를 호출할 수는 없고 KeySet() 또는 entrySet()과 같은 메서드로
        // Set타입으로 변경한 뒤 다시 iterator()를 호출하는 식으로 진행을 한다고 한다.

        // 이런 맵타입이 존재한다고 가정
        Map map = new HashMap();

        // 우선 Set타입으로 변경 후 생성하는 방법
        Set mSet = map.entrySet();
        Iterator iteratorSet = mSet.iterator();

        // 위의 2줄을 압출해서 하는 방법 (같다고 생각하면 된다)
        Iterator iteratorMap = map.entrySet().iterator();

        // Iterator를 사용하면 컬렉션에서 제시하는 표준적인 읽기방법을 수행하는 것이므로
        // 코드의 재사용성을 높이고 일관성을 유지하는 장점이 있다고 한다.
        // 다만 다른 의견으로는 일반적으로 느리다는 평도 있다. 그렇지만 유지보수성과 확장성 등을 고려하면 사용을 해보자

        /*Enumeration*/
        // 우선 Enumeration은 컬렉션 프레임워크 이전의 Iterator라고 불린다
        // Enumeration은 전에도 언급된 Vector 같은 구시대(?)의 구조들에 사용했다고 한다.
        // 호환성을 위해서 남겨둔 기능이기도 하니 컬렉션을 사용한다면 Iterator를 권장한다.

        // 간단한 사용을 위해서 Vector를 불러오자.
        Vector<Integer> vector = new Vector<>();

        // addElement(Object)를 이용해서 값을 넣자.
        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);
        vector.addElement(5);

        // 여기서부터는 Iterator를 사용할때랑 많이 비슷하다.
        Enumeration<Integer> enumeration = vector.elements();

        // hasMoreElements()는 Iterator의 hasNext()처럼 읽어올 요소를 확인하는 메서드이다.
        while (enumeration.hasMoreElements()) {
            // nextElement() 또한 next()처럼 다음 요소를 읽어오는 메서드이다.
            System.out.println(enumeration.nextElement());
        }
        // 해당 인터페이스에 들어가보면 알겠지만 2개의 메서드가 전부이다..
        System.out.println();

        /*ListIterator*/
        // ListIterator는 Iterator에 이전방향으로의 접근이 추가된 것이라고 한다.
        // Collection에는 ListIterator가 없고 List에만 존재한다.
        List<Character> link = new LinkedList<>();
        link.add('a');
        link.add('b');
        link.add('c');

        ListIterator<Character> linkItreator = link.listIterator();

        // hasNext()는 읽어 올 다음요소가 있는지 확인한다. 방향은 정방향이다. ->
        while (linkItreator.hasNext()) {
            // next()는 다음 요소를 읽어 온다. nextIndex()는 다음 인덱스의 값을 가져온다.
            System.out.printf("현재값은 %s이고 다음 인덱스는 %d입니다.\n", linkItreator.next(), linkItreator.nextIndex());
        }

        System.out.println();

        // hasPrevious()는 읽어 올 다음요소가 있는지 확인한다. 방향은 역방향이다. <-
        while (linkItreator.hasPrevious()) {
            // previous()는 이전 요소를 읽어 온다. previousIndex()는 이전 인덱스의 값을 가져온다.
            System.out.printf("현재값은 %s이고 이전 인덱스는 %d입니다.\n", linkItreator.previous(), linkItreator.previousIndex());
        }

        // 위의 6개의 메서드말고도 3개의 선택적 메서드가 존재한다.
        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(5);
        integers.add(6);

        ListIterator<Integer> integerListIterator = integers.listIterator();

        // add(Object)로 컬렉션에 객체를 추가할 수 있다.
        integerListIterator.add(1);
        integerListIterator.add(2);
        integerListIterator.add(3);

        // 결과를 보면 알겠지만 앞에서부터 값이 들어간다.
        System.out.println("현재 배열 확인 -> " + integers);

        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }

        // 사용하기 위해서는 위처럼 hasNext() 또는 hasPrevious()를 사용하여 확인해야 한다.
        integerListIterator.set(999);
        // 확인을 해보니 ListIterator로 추가된 객체들은 변경이 안된다.
        // 오직 기존에 존재하던 객체들만 변경이 가능

        System.out.println("현재 배열 확인 -> " + integers);

        while (integerListIterator.hasPrevious()) {
            System.out.println(integerListIterator.previous());
        }

        // set()처럼 has..()를 통한 확인이 선행되어야 하며 마지막으로 가져온 값을 제거한다.
        integerListIterator.remove();

        System.out.println("현재 배열 확인 -> " + integers);
    }

}
