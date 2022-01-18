package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// TreeSet은 "이진 검색 트리"라는 자료구조의 형태로 저장하는 컬렉션 중 하나이다.
// 이진 검색트리는 정렬, 검색, 범위검색에 높은 성능을 보이는 자료구조이다.

// Set 인터페이스를 기반이기 때문에 중복 허용금지, 저장순서 유지 x
public class Chap_12 {

    // 링크드리스트처럼 여러 개의 노드가 연결된 구조로 각 노드는 최대 2개의 노드를 연결할 수 있으며
    // "루트"라고 불리는 하나의 노드에서 시작해서 확장해 나가는 구조이다.
    // 위 아래로 연결된 두 노드를 부모-자식 관계라고 부르며 위가 부모 아래가 자식이다.
    // 부모노드의 왼쪽에는 부모보다 작은값 오른쪽에는 부모보다 큰값을 저장한다.
    // 비교를 할 때에는 Comparable을 구현 또는 Comparator를 제공을 해줘야 한다.
    // 값을 읽어올 때는 왼쪽노드 -> 부모노드 -> 오른쪽노드 순으로 읽으면 오름차순이 완성된다.
    // 트리는 검색효율이 뛰어난 자료구조이다. 하지만 노드관계로 인해서 자료의 추가/삭제가 느리다는 단점이 있다.
    /*  이런구조이다.

                    8(root)
                  /  \
                5     13
              /  \
            4     7
       여기서 5는 4,7의 부모. 4,7은 5의 자식이다.
    */
    public static void main(String[] args) {
        // 기본생성자로 생성하는 방법
        TreeSet ex1 = new TreeSet();

        // 주어진 컬렉션을 저장하는 트리셋
        TreeSet ex2 = new TreeSet(new LinkedList());

        // 주어진 정렬조건으로 정렬하는 트리셋 생성
        TreeSet ex3 = new TreeSet(new Chap_10.Example());

        /*add(Object), addAll(Collection)*/
        // 지정된 객체 또는 컬렉션의 "객체들을" 저장한다.
        // 반환타입 : boolean
        TreeSet treeSet = new TreeSet();
        treeSet.add(5);
        List list = new LinkedList();
        list.add(6);
        list.add(7);
        list.add(9);
        // 예시에서는 단순 숫자이기 떄문에 아무런 에러가 발생하지 않으나
        // 문자열이나 객체를 넣을 경우에는 꼭 Comparable 또는 Comparator로 정렬기준을 제시해줘야 한다.
        treeSet.addAll(list);

        /*ceiling(Object)*/
        // 지정된 객체와 같은 객체를 반환, 없으면 큰 값을 가진 객체 중 제일 가까운 값을 반환, 없으면 null
        // 반환타입 : Object
        System.out.println(treeSet.ceiling(5));
        System.out.println(treeSet.ceiling(8));
        System.out.println(treeSet.ceiling(10));

        /*clear()*/
        // 모든 객체를 삭제한다.
        // 반환타입 : void
        treeSet.clear();

        /*clone()*/
        // 복제하여 반환한다.
        // 반환타입 : Object
        Set set = (Set) treeSet.clone(); // 이런식으로 응용이 가능하다.

        /*comparator()*/
        // 해당 트리셋의 정렬기준(Comparator)를 반환한다.
        // 반환타입 : Comparator
        Comparator c = treeSet.comparator();

        /*contains(Object), containsAll(Collection)*/
        // 지정된 객체 또는 "컬렉션의 객체들"이 포함되어 있는지 확인한다.
        // 반환타입 : boolean
        print(list);
        treeSet.add(5);
        treeSet.add(11);
        print(treeSet);
        System.out.println(treeSet.containsAll(list));
        System.out.println(treeSet.contains(11));

        /*descendingSet()*/
        // 해당 트리셋에 저장된 요소들을 역순으로 정렬한 뒤 반환한다.
        // 반환타입 : NavigableSet
        NavigableSet navigableSet = treeSet.descendingSet();
        print(navigableSet);
        navigableSet.add(7); // 알아서 잘 정렬이 된다.
        navigableSet.add(13); // 알아서 잘 정렬이 된다.
        navigableSet.add(16); // 알아서 잘 정렬이 된다.

        // NavigableSet의 부모는 SortedSet인데 해당 인터페이스로 트리셋을 생성할 수도 있다.
        TreeSet ex4 = new TreeSet(navigableSet); // 파라미터가 "SortedSet"이다.
        print(ex4);

        /*first()*/
        // 정렬된 순서에서 첫 번째 객체를 반환한다.
        // 반환타입 : Object
        System.out.println(ex4.first());
        System.out.println(treeSet.first());

        /*floor(Object)*/
        // ceiling()이랑 비슷한 메서드이다. 다만 작은값을 찾는다는게 다른다.
        // 반환타입 : Object
        print(treeSet);
        System.out.println(treeSet.floor(6));
        System.out.println(treeSet.floor(4));

        /*headSet(Object)*/
        // 지정된 객체보다 작은 값의 "객체들을" 반환한다.
        // 반환타입 : SortedSet
        SortedSet sortedSet = treeSet.headSet(11);
        print(sortedSet);

        /*headSet(Object, boolean)*/
        // 지정된 객체보다 작은 값의 "객체들을" 반환, true일 경우 같은 값도 포함한다.
        // 반환타입 : NavigableSet
        NavigableSet navigableSet1 = treeSet.headSet(11, true);
        print(navigableSet1);

        /*higher(Object)*/
        // 지정된 객체보다 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환, 없으면 null
        // 반환타입 : Object
        System.out.println(treeSet.higher(14));

        /*isEmpty()*/
        // 트리셋이 비어있는지 확인한다.
        // 반환타입 : boolean
        System.out.println(treeSet.isEmpty());

        /*iterator()*/
        // iterator를 반환한다.
        // 반환타입 : Iterator
        Iterator iterator = treeSet.iterator();

        /*last()*/
        // 정렬된 순서에서 마지막 객체를 반환한다.
        // 반환타입 : Object
        System.out.println(treeSet.last());

        /*lower(Object)*/
        // 지정된 객체보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환, 없으면 null
        // 반환타입 : Object
        System.out.println(treeSet.lower(14));

        /*pollFirst(), pollLast()*/
        // 해당 트리렛의 첫번째 요소, 마지막 요소를 반환한다. (트리셋에서 제거된다)
        // 반환타입 : Object
        System.out.println(treeSet.pollFirst());
        System.out.println(treeSet.pollLast());

        /*remove(Object)*/
        // 지정된 객체를 삭제한다.
        // 반환타입 : boolean
        System.out.println(treeSet.remove(13));
        print(treeSet);

        /*retainAll(Collection)*/
        // 주어진 컬렉션과 공통된 요소만을 남기고 삭제한다.
        // 반환타입 : boolean
        TreeSet set1 = new TreeSet();
        set1.add(7);
        treeSet.retainAll(set1);
        print(treeSet);

        /*size()*/
        // 저장된 객체의 수를 반환한다.
        // 반환타입 : int
        System.out.println(treeSet.size());

        /*tailSet(Object)*/
        // 지정된 객체보다 큰 값의 객체들을 반환한다.
        // 반환타입 : SortedSet
        treeSet.add(10);
        treeSet.add(13);
        treeSet.add(15);
        treeSet.add(17);
        SortedSet s = treeSet.tailSet(13);
        print(s);

        /*toArray()*/
        // 저장된 객체를 객체배열로 변경
        // 반환타입 : Object[]
        Object[] o = treeSet.toArray();

        /*subSet(Object, Object)*/
        // 첫번째 오브젝트 부터 마지막 오브젝트까지(마지막은 포함안함)의 결과를 반환한다.
        // 반환타입 : SortedSet
        SortedSet s1 = treeSet.subSet(9, 14);
        print(treeSet);
        print(s1);

        /*subSet(Object, boolean, Object, boolean)*/
        // 첫번째 오브젝트 부터 마지막 오브젝트까지의 결과를 반환하는데 boolean이 true일 경우 시작값과 끝값을 포함
        // 반환타입 : NavigableSet
        NavigableSet n = treeSet.subSet(7, true, 13, false);
        print(n);

    }

    static void print(Collection collection) {
        System.out.println("\n출력");
        System.out.println("=====================");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=====================");
    }

}
