package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// 이제부터는 앞에서 배웠던 컬렉션 프레임워크의 인터페이스의 "구현체"를 다뤄본다.
// 가장 많이들 사용하고 사용하기가 상대적으로 쉬운(?) 구현체인 "ArrayList"를 다룬다.
public class Chap_05 {

    // ArrayList는 이름부터 알 수 있는 것처럼 List의 구현체이다.
    // 그렇기에 List가 가진 특성인 중복값 허용, 순서대로 저장을 위한 용도이다.
    public static void main(String[] args) {

        // 사용방법은 이렇다. 이렇게 생성시 "크기가 10"인 ArrayList를 생성한다.
        ArrayList arr1 = new ArrayList();

        // 주어진 컬렉션이 저장된 ArrayList 생성, ArrayList도 컬렉션이니 가능하다.
        ArrayList arr2 = new ArrayList(new ArrayList());

        // 용량을 정해서 생성할려면 이렇게 하면 100의 용량을 가진 배열이 생성된다.
        ArrayList arr3 = new ArrayList(100);

        /*이제부터 ArrayList에서 주로 사용되는 메서드들을 살펴보자, 용량은 "1"이다*/
        ArrayList arrayList = new ArrayList(1);

        /*add(Object)*/
        // 해당 ArrayList의 "마지막"에 지정된 객체를 추가한다. 성공 시 true를 반환한다.
        // 반환타입 : boolean
        arrayList.add(5);
        print(arrayList, 1);

        /*add(int, Object)*/
        // 위의 add와 같으나 "지정된 위치"에 객체를 저장하는것이 다르다.
        // 반환타입 : void
        arrayList.add(0, "하이!");
        print(arrayList, 2);

        /*
            그리고 해당 메서드를 사용하면 눈치챘을 것이다. "용량이 자동으로 증가"하는 것을
            그렇다 ArrayList는 공간이 부족하다면 자동으로 더 큰 새로운 배열을 "생성"해서
            기존의 내용을 "복사"하여 저장을 하는 방식이다. 매우 중요한 개념이니 꼭 기억해야 한다.
            "기존의 배열이 자동으로 증가하는 것이 아닌 새로운 배열을 만들어 추가하는 방식을 기억하자!"
        */

        /*
            또한 두번째에 add를 할 때 String타입을 해도 전혀 문제가 되지 않는 이유는
            ArrayList가 elementData라는 Object배열을 멤버변수로 선언하고 있기 때문이다.
            그래서 모든 객체의 최고조상인 Object를 다루기 때문에 모든 객체를 담을 수 있는 것이다.
        */

        /*addAll(Collection), addAll(int, Collection)*/
        // 주어진 컬렉션의 "모든 객체"를 저장한다. 또한 위치(index)를 지정하여 넣을 수 있다.
        // 반환타입 : boolean
        ArrayList arr4 = new ArrayList();
        ArrayList arr5 = new ArrayList();
        arr4.add("헬로우월드");
        arr5.add("헬로우자봐!");
        arr5.add("헬로우파이쏜!");
        arrayList.addAll(arr4);
        arrayList.addAll(1, arr5);// 이렇게 위치를 지정할 수 있다.
        print(arrayList, 3);

        /*clear()*/
        // ArrayList를 완전히 싹 비운다.
        // 반환타입 : void
        arrayList.clear();
        print(arrayList, 4);

        /*clone()*/
        // ArrayList를 복사(복제)합니다. 다만 해당 메서드를 이용하면 "얇은 복사"가 된다는 것을 기억하자
        // 반환타입 : Object
        arrayList.add("안녕하세요~");
        ArrayList copy = (ArrayList) arrayList.clone(); // Object타입이므로 캐스팅을 해야한다.
        print(copy, 5);

        /*contains(Object)*/
        // 지정된 객체가 ArrayList에 포함되어 있는지 확인한다.
        // 반환타입 : boolean
        System.out.println("\nArrayList contains()");
        System.out.println(arrayList.contains(1));
        System.out.println(arrayList.contains("안녕하세요~"));

        /*ensureCapacity(int)*/
        // ArrayList의 용량이 최소한 int값만큼 되도록 한다.
        // 반환타입 : void
        copy.ensureCapacity(1000);

        /*get(int)*/
        // 해당 위치의 저장된 객체를 반환한다.
        // 반환타입 : Object
        System.out.println("\nget() : " + arrayList.get(0));

        /*indexOf(Object)*/
        // 지정된 객체가 저장된 "위치"를 찾아서 반환한다.
        // 반환타입 : int
        System.out.println("\nindexOf() : " + arrayList.indexOf("안녕하세요~"));
        System.out.println("indexOf() : " + arrayList.indexOf("값이 없다면 -1을 반환"));

        /*isEmpty()*/
        // 해당 ArrayList가 비어있는지 확인한다. 비어있다면 true를 반환한다.
        // 반환타입 : boolean
        arrayList.clear();
        System.out.println("\nisEmpty() : " + arrayList.isEmpty());
        arrayList.add("헬로우!");
        System.out.println("isEmpty() : " + arrayList.isEmpty());

        /*lastIndexOf(Object)*/
        // 지정된 객체를 "끝에서부터" 검색해서 반환한다.
        // 반환타입 : int
        arrayList.add(0, "자봐!");
        arrayList.add(1, "파이썬!");
        arrayList.add(3, "스크립투!");
        print(arrayList, 6);
        System.out.println("\nlastIndexOf() : " + arrayList.lastIndexOf("헬로우!"));

        /*remove(int)*/
        // 지정된 "위치"의 객체를 제거하고 반환한다.
        // 반환타입 : Object
        String ex1 = (String) arrayList.remove(1);
        System.out.println("\nremove() : " + ex1);
        print(arrayList, 7);

        /*remove(Object)*/
        // 지정된 객체를 제거한다.
        // 반환타입 : boolean
        boolean bool1 = arrayList.remove("스크립투!");
        boolean bool2 = arrayList.remove("모르는객체!");
        System.out.println("\nremove() : " + bool1);
        System.out.println("remove() ; " + bool2);
        print(arrayList, 8);

        /*removeAll(Collection)*/
        // 지정된 컬렉션과 동일한 객체들을 제거한다. 쉽게 말하면 비교해서 공통적인 객체들을 제거한다.
        // 반환타입 : boolean
        print(arrayList, 9);
        ArrayList arrayListExample = new ArrayList();
        arrayListExample.add("자봐!");
        arrayListExample.add("파이쏜!");
        boolean bool3 = arrayList.removeAll(arrayListExample);
        System.out.println("\nremoveAll() : " + bool3);
        print(arrayList, 10);

        /*retainAll(Collection)*/
        // 지정된 컬렉션과 "공통된 것"을 남기고 나머지는 삭제한다. removeAll과는 반대로 공통적인 객체를 남기고 나머지를 삭제
        // 반환타입 : boolean
        arrayListExample.add("헬로우!");
        System.out.println("\nretainAll() 적용전");
        print(arrayListExample, 11);
        arrayListExample.retainAll(arrayList);
        System.out.println("\nretainAll() 적용후");
        print(arrayListExample, 12);

        /*set(int, Object)*/
        // 주어진 객체를 지정된 위치(int)에 저장한다, add랑 비슷해서 헷갈릴 수 있으니 주의
        // 반환타입 : Object
        arrayList.add(0,"하이~");
        arrayList.add(0,"하이~~~");
        print(arrayList, 13);
        arrayList.set(0, "Hello!");
        arrayList.set(0, "Hello!!!");
        print(arrayList, 14);
        // add 같은 경우는 말그대로 "추가"한다는 개념이지만 set은 "변경"에 가깝다고 생각하면 된다.

        /*size()*/
        // ArrayList에 저장된 "객체의 개수"를 반환한다. 배열의 길이가 아니라 "객체의 개수"이다.
        // 반환타입 : int
        ArrayList arr6 = new ArrayList(1000000);
        System.out.println("\nsize() : " + arr6.size()); // 아무 값도 넣지 않았다.
        System.out.println("size() : " + arrayList.size());

        /*subList(int, int)*/
        // 첫번째 int부터 두번째 int값 사이에 저장된 객체를 반환한다. 두번째 int값은 범위에 포함하지 않는다.
        // 반환타입 : List
        System.out.println("\nsubList() : " + arrayList.subList(1, 2));

        /*trimToSize()*/
        // 용량을 크기에 맞게 줄인다. 빈 공간을 제거한다.
        // 반환타입 : void
        ArrayList arr7 = new ArrayList(100000000);
        arr7.add("안녕하세요");
        arr7.trimToSize();

        /*toArray()*/
        // ArrayList의 모든 객체들을 객체배열로 반환한다.
        // 반환타입 : Object[]
        Object[] objects = arrayList.toArray();
        System.out.println("\ntoArray()로 변경");
        for (Object o : objects) {
            System.out.println(o);
        }

        // 이 외에도 다른 ArrayList 메서드들이 있으나 여기서는 기본적인 것만 입력했다.
    }

    // 출력용 메서드
    static void print(ArrayList arr, int page) {
        System.out.println("\n" + page + "번째 print 메서드 사용!");
        if (arr.isEmpty()) {
            System.out.println("해당 ArrayList는 값이 없어요!!!");
        } else {
            for (Object o : arr) {
                System.out.println(o);
            }
        }
    }

}
