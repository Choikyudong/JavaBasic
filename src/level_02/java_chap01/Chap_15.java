package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// 이제 여기서 해당 클래스를 공부하는 것은 마지막이다.
// Collections 는 Arrays 처럼 컬렉션과 관련된 다양한 메서드를 제공해준다.
public class Chap_15 {

    /*밑에 보면 ...이 있는데 ...에는 List, Map, Set처럼 타입을 입력하는 공간이다.*/
    public static void main(String[] args) {
        /*synchronized...*/
        // Vector, Hashtable 같은 구버전 컬렉션들은 자체적으로 "동기화"가 되어있다
        // 하지만 불필요한 동기화는 성능만 떨어뜨리니 현재 컬렉션은 되어있지않다.
        // 하지만 때로는 동기화가 필요할 떄가 있는데 이 메서드는 해당 컬렉션을 동기화 시켜주는 메서드이다.
        Collection collection = new LinkedList();
        Collections.synchronizedCollection(collection);
        List list = new ArrayList();
        Collections.synchronizedList(list);
        Set set = new HashSet();
        Collections.synchronizedSet(set);
        Map map = new HashMap();
        Collections.synchronizedMap(map);
        // 바로 만들려면 이렇게 하면 된다.
        List syncList = Collections.synchronizedList(new ArrayList<>());

        /*unmodifiable...*/
        // 해당 컬렉션에 저장된 데이터를 보호하기 위해서 컬렉션의 내용을 변경못하게 만드는 기능이다.
        // 주로 멀티쓰레드 환경에서 방지하기 위해서 사용한다고 한다. (꼭 그렇게 쓰라는 것은 아니다)
        List list1 = new ArrayList();
        Collections.unmodifiableList(list1);
        Set set1 = new TreeSet();
        Collections.unmodifiableSet(set1);
        // 물론 동기화시킨 컬렉션도 가능하다.
        Collections.unmodifiableList(syncList);

        /*singleton...*/
        // 해당 컬렉션을 싱글톤으로 만드는 메서드이다.
        // 싱글톤은 OOP 디자인패턴 중 하나로 하나의 객체를 계속해서 돌려쓸 때 이용한다.
        Collections.singleton(set1);
        Collections.singletonList(list1);
        Map singleMap =  Collections.singletonMap("나 키값", "나 벨류");

        /*checked...*/
        // 해당 메서드는 원하는 하나의 객체만 저장하는 기능이다.
        // 앞에서부터 봤다시피 컬렉션은 객체를 담는 저장구조로 모든 객체는 저장이 된다는 것이 장점이다.
        // 때로는 그런점이 단점이 될 수 있는데 그런 요소를 해결해주는 메서드이다.
        /*보이는것처럼 자유롭게 원하는 객체를 넣을 수 있다.*/
        List arraylist = new ArrayList();
        arraylist.add(1);
        arraylist.add("바보야");
        arraylist.add(true);
        print(arraylist);
        List checkList = Collections.checkedList(arraylist, Integer.class);
        try {
            checkList.add(5);
            checkList.add("안녕");
        } catch (ClassCastException e) {
            System.out.println("---------");
            System.out.println("에러 발생 : " + e.getMessage());
            System.out.println("---------");
        }
        print(checkList); // 기존에 있던 값들이 사라지거나 그러지는 않는다.
        // 해당 메서드는 처음보면 와 정말 좋아보이는데라고 생각할 뻔 하지만
        // 1.5버전에 제네릭스이 도입되고 부터는 호환성을 위해서만 존재할 뿐 사용할 필요는 딱히 없을 것이다.

        // 이 외에도 다른 메서드들이 많으나 딱히 언급하지않고 넘어가는 이유는
        // Chap_09에서 다뤘던 메서드들이랑 크게 차이가 없기 때문이다.

        /*이로써 컬렉션을 짧게 정리를 해봤는데 정말 분량이 많다;*/
        /*그만큼 많이 사용되니 꼭 알고가면 좋다.*/

    }

    static void print(Collection collection) {
        System.out.println("\n=========================");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=========================\n");
    }
}
