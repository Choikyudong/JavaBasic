package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// HashSet
// 해쉬셋은 Set의 대표적인 구현체이다.
// Set이 가진 특징대로 순서가 없으면서 중복값을 가지지 않는다.
public class Chap_11 {

    public static void main(String[] args) {
        // HashSet을 생성한다.
        HashSet ex1 = new HashSet();

        // Collection을 포함하는 HashSet을 생성한다.
        HashSet ex2 = new HashSet(new ArrayList());

        // 주어진 값(int)을 초기용량으로 하는 HashSet 생성
        HashSet ex3 = new HashSet(1000);

        // 초기용량과 loadFactor를 지정하는 생성자
        HashSet ex4 = new HashSet(100,0.8f);
        /*loadFactor는 저장공간이 가득 차기 전에 미리 용량을 확보하기 위한 것으로 값이 0.8로 지정할 경우*/
        /*80%가 가득채워졌을 때 용량이 2배로 늘어난다. 개본값은 0.75이다. (75%라는 말)*/

        /*add(Object)*/
        // 지정한 객체를 저장한다.
        // 반환타입 : boolean
        HashSet hashSet = new HashSet();
        hashSet.add("안녕하세요!");
        print(hashSet, 1);

        /*addAll(Collection)*/
        // 주어진 컬렉션에 저장된 "모든 객체"들을 추가한다.
        // 반환타입 : boolean
        ArrayList arrayList = new ArrayList();
        arrayList.add("반갑습니다!");
        hashSet.addAll(arrayList);
        print(hashSet, 2);

        /*clear()*/
        // 해당 HashSet에 "모든 객체"를 제거한다.
        // 반환타입 : void
        hashSet.clear();
        print(hashSet, 3);

        /*clone()*/
        // HashSet을 복제해서 반환한다. (얕은 복사)
        // 반화타입 : Object
        Object clone = hashSet.clone();

        /*contains(Object)*/
        // 지정된 객체를 포함하는지 확인한다.
        // 반환타입 : boolean
        hashSet.add("안뇽!");
        System.out.println(hashSet.contains("안뇽!"));
        System.out.println(hashSet.contains("안뇽"));

        /*containsAll(Collection)*/
        // 지정된 컬렉션에 저장된 "모든 객체"를 포함하는지 확인한다.
        // 반환타입 : boolean
        LinkedList list = new LinkedList();
        list.add("안뇽!");
        System.out.println(hashSet.containsAll(list));
        list.add("헬로우!");
        System.out.println(hashSet.containsAll(list));

        /*isEmpty()*/
        // 해당 HashSet이 비어있는지 확인한다. 비어있다면 true를 반환한다.
        // 반환타입 : boolean
        System.out.println(hashSet.isEmpty());
        hashSet.clear();
        System.out.println(hashSet.isEmpty());

        /*iterator()*/
        // iterator를 반환한다.
        // 반환타입 : Iterator
        Iterator iterator = hashSet.iterator();

        /*remove(Object)*/
        // 지정된 객체를 삭제한다, 성공 시 true
        // 반환타입 : boolean
        hashSet.add("헬로우!");
        hashSet.add("헬로우!!");
        print(hashSet, 4);
        hashSet.remove("헬로우!");
        print(hashSet, 5);

        /*removeAll(Collection)*/
        // 주어진 컬렉션에 저장된 모든 "객체와 동일한 것"들을 모두 삭제한다.
        // 반환타입 : boolean
        HashSet ex = new HashSet();
        ex.add("헬로우!");
        ex.add("헬로우!!");
        ex.add("헬로우!!!");
        ex.removeAll(hashSet);
        System.out.println(ex);

        /*retainAll(Collection)*/
        // 주어진 컬렉션에 "동일한 객체만" 남기고 모두 삭제한다.
        // 반환타입 : boolean
        hashSet.add("헬로우!!!");
        ex.retainAll(hashSet);
        System.out.println(ex);

        /*size()*/
        // 저장된 객체의 개수를 반환한다.
        // 반환타입 : int
        System.out.println();
        System.out.println(hashSet.size());
        System.out.println(hashSet);
        System.out.println(ex.size());
        System.out.println(ex);

        /*toArray()*/
        // 저장된 객체들을 객체배열의 형태로 반환한다.
        // 반환타입 : Object[]
        var var = hashSet.toArray();
        for (Object o : var) {
            System.out.println(o);
        }

    }

    static void print(Set<?> set, int page) {
        System.out.println("\n" + page + "번째 출력입니다.");
        if (set.isEmpty()) {
            System.out.println("해당 Set에는 값이 없어요!");
            return;
        }
        Iterator<?> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
