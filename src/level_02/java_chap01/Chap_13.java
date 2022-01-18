package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// 이제 거의 끝이다. 앞에까지는 Collection이라는 인터페이스에서
// 내려오는 것들을 구현헀는데 여기서는 Map이라는 인터페이스를 기반으로 다룬다.

// 그중에서 가장 많이 사용하는 HashMap을 우선적으로 살펴본다.
// 우선 HashMap은 Map의 특징대로 key-valeu의 한 쌍을 묶어서 데이터(entry)로 저장하는 특성이 있다.
// 그리고 "해싱(hashing)"을 사용하기 때문에 많은 양의 데이터를 검색하는데 좋은 성능을 보여준다.
public class Chap_13 {

    // 기존에 List나 Set은 무언가를 저장시킬 때 "배열"이라는 기본적인 구조를 이용했다.
    // 곰곰히 생각해보면 Map은 그런 배열의 구조를 이용하지않고 데이터를 저장할 수 있다.

    // 이유는 Map 인터페이스를 들어가보면 406번째 라인에 Entry라는 인터페이스가 존재한다.
    // 그리고 실제로 HashMap에 저장이 되는 "객체"가 이 Entry를 구현시킨 "객체"이다.
    // 즉 Entry라는 클래스안에 key와 value값을 저장한 뒤 사용하는 방식이다.

    // 키값은 저장된 값을 찾는데 사용하기 때문에 컬렉션 내에서 유일해야한다.
    // Chap_04랑 보면 좋다.
    public static void main(String[] args) {
        // 기본 생성자로 생성
        HashMap map1 = new HashMap();

        // 지정된 값을 초기용량으로 생성
        HashMap map2 = new HashMap(1000);

        // 지정된 초기용량과 load factor 설정이 된 생성
        HashMap map3 = new HashMap(1000, 0.9f);

        // 지정된 Map의 "모든 요소"를 포함하는 HashMap 생성 (오직 Map 타입)
        HashMap map4 = new HashMap(new HashMap());
        //HashMap map5 = new HashMap(new ArrayList<>()); 같은 컬렉션프레임워크이지만 타입이 다르다

        /*put(Object, Object)*/
        // 지정된 키와 값을 맵에 저장한다.
        // 반환타입 : Object
        System.out.println("put");
        HashMap hashMap = new HashMap();
        hashMap.put(1, "안녕");
        hashMap.put("반가워", 2);
        System.out.println(hashMap);
        System.out.println();

        /*get(Object)*/
        // 지정된 키값(Object)로 값을 반환한다. 못찾으면 null
        // 반환타입 : Object
        /*키 값을 집어 넣어야 한다는 것을 잊지말자*/
        System.out.println("get");
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get("반가워"));
        System.out.println(hashMap.get("엉?"));
        System.out.println();

        /*getOrDefault(Object,Object)*/
        // 지정된 키값이 없다면 기본값(두번째파라미터)을 반환한다.
        // 반환타입 : Object
        System.out.println("getOrDefault");
        System.out.println(hashMap.getOrDefault(1, "없네요???"));
        System.out.println(hashMap.getOrDefault("엉?", "없네요???"));
        System.out.println();

        /*putAll(Map)*/
        // 해당 Map의 모든 요소를 저장한다.
        // 반환타입 : void
        System.out.println("putAll");
        Map map = new HashMap();
        map.put("헬로!", "자바");
        map.put("헬로!!", "자바스크립트");
        map.put("헬로!!!", "파이썬");
        hashMap.putAll(map);
        System.out.println(hashMap);
        System.out.println();

        /*containsKey(Object)*/
        // 지정된 키가 해당하는 HashMap에 포함이 되어있는지 확인한다.
        // 반환타입 : boolean
        System.out.println("containsKey");
        System.out.println(hashMap.containsKey("헬로!"));
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsKey("이게 있나?"));
        System.out.println();

        /*containsValue(Object)*/
        // 지정된 값이 해당하는 HahsMap에 포함하는지 확인한다.
        // 반환타입 : boolean
        System.out.println("containsValue");
        System.out.println(hashMap.containsValue("자바스크립트"));
        System.out.println(hashMap.containsValue("c++"));
        System.out.println(hashMap.containsValue("2"));
        System.out.println();

        /*remove(Object)*/
        // 지정된 키로 저장된 값을 제거한다.
        // 반환타입 : Object
        System.out.println("remove");
        System.out.println(hashMap.remove("헬로!!!"));
        System.out.println(hashMap.remove("엥??"));
        // 값까지 지정하여 사용이 가능하며 이럴 때 반환타입은 boolean이다.
        System.out.println(hashMap.remove(1, "안녕"));
        System.out.println(hashMap.remove("헬로!!", "자바"));
        System.out.println(hashMap);
        System.out.println();

        /*replace(Object, Object)*/
        // 지정된 키값으로 된 값을 지정된 값으로 변경한다.
        // 반환타입 : Object
        System.out.println("replace");
        System.out.println(hashMap.replace("헬로!!", "자바"));
        // 값까지 지정하여 사용이 가능하며 이럴 때 반환타입은 boolean이다.
        System.out.println(hashMap.replace("반가워", "2", "World!"));
        System.out.println(hashMap);
        System.out.println();

        /*entrySet()*/
        // HashMap에 저장된 키값을 엔트리 형태로 Set에 저장해서 반환
        // 반환타입 : Set
        System.out.println("entrySet");
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");

        /*values()*/
        // 저장된 "모든 값"을 "컬렉션 형태"로 변환한다, key는 포함하지 않는다.
        // 반환타입 : Collection
        System.out.println("values");
        Collection collection = hashMap.values();
        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println();

        /*clone()*/
        // 지정된 HashMap을 복제한다.
        // 반환타입 : Object
        Map clone = (Map) hashMap.clone();
        System.out.println("clone");
        System.out.println(clone.get(1));
        System.out.println();

        /*isSize()*/
        // 저장된 모든 객체의 수를 반환
        // 반환타입 : int
        System.out.println("size");
        System.out.println(hashMap.size());
        System.out.println();

        /*clear()*/
        // 모든 객체 제거
        // 반환타입 : void
        hashMap.clear();

        /*isEmpty()*/
        // 비어있는지 알려준다.
        // 반환타입 : boolean
        System.out.println("\nisEmpty : " + hashMap.isEmpty());

        /*끝으로 해싱(Hashing)에 대해서 간단하게 짚고 넘어가면*/
        /*
            해시함수를 이용해서 데이터를 "해시테이블"에 저장하고 검색하는 기법을 말한다.
            해시함수는 데이터가 저장되어 있는 곳을 알려 주기 때문에 다량의 데이터에서도 빠르게 찾을 수 있다.
         */
        // HashMap말고 TreeMap이라는 것이 있는데
        // 해당 Map은 기존에 배웠던 TreeSet에 들어간 방식인
        // 이진검색트리 구조를 Map형식으로 구현한 것이다. 여기서는 TreeSet은 넘어간다.
    }

}