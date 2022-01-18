package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// 이전에 살펴봤던 ArrayList는 가장 사용하기 쉽고 데이터를 읽어오는데 빠르다는 장점이 있다.
// 하지만 단점으로는 크기를 변경할 수 없으며 동시에 중간에 데이터를 삽입을 하는 것은 오래 걸린다는 것이다.
public class Chap_06 {

    // LinkedList는 위에서 언급된 단점을 보완하기 위한 구조이다.
    // 다른 배열처럼 연속적으로 데이터를 입력하지만 연결방식이 조금 다르다는 것이다.
    // 조금 더 풀어서 말을 하면 node(요소)들을 참조값으로 연결을 한다는 것이다.

    // 다만 LinkedList는 단방향으로만 다음 요소에 접근이 가능하다는 단점이 존재한다.
    // 그래서 DoublyLinkedList라는 양방향으로 움직이는 것도 있다.
    // 컬렉션 프레임워크에서는 더블링크드리스트가 구현이 되어있다. 편의상 그냥 링크드리스트라고 부르자.
    public static void main(String[] args) {

        // 이렇게 하면 링크드리스트를 선언할 수 있다.
        LinkedList list1 = new LinkedList();

        // 주어진 컬렉션이 저장된 LinkedList도 생성이 가능하다.
        LinkedList list2 = new LinkedList(list1);

        /*add(Object)*/
        // 지정된 객체를 해당 링크드리스트의 "마지막(끝)"에 추가한다. 성공시 true
        // 반환타입 : boolean
        LinkedList linkedList = new LinkedList();
        linkedList.add("안녕하세요!");
        printLinkedList(linkedList, 1);

        /*add(int, Object)*/
        // 지정된 위치(int)에 지정된 객체를 추가한다.
        // 반환타입 : void
        linkedList.add(0, "Hello~~");
        printLinkedList(linkedList, 2);

        /*addAll(Collection), addAll(int, Collection)*/
        // 주어진 컬렉션의 "모든 객체"를 해당 링크드 리스트에 추가한다. int 추가시 지정된 위치에 추가한다.
        // 반환타입 : boolean
        LinkedList list3 = new LinkedList();
        list3.add("자봐!");
        list3.add("파이쏜!");
        linkedList.addAll(1, list3);
        printLinkedList(linkedList, 3);

        /*claer()*/
        // LinkedList를 완전히 싹 모조리 내용을 제거한다.
        // 반환타입 : void
        linkedList.clear();
        printLinkedList(linkedList, 4);

        /*contains(Object)*/
        // 지정한 객체가 포함이 되어있는지 알려준다.
        // 반환타입 : boolean
        linkedList.add(5);
        System.out.println("\ncontains : " + linkedList.contains(5));
        System.out.println("contains : " + linkedList.contains("5"));

        /*containsAll(Collection)*/
        // 지정된 컬렉션의 "모든 요소"가 존재하는지 확인, 하나만 같으면 안된다.
        // 반환타입 : boolean
        LinkedList exp1 = new LinkedList();
        exp1.add("5");
        exp1.add("이건 없지롱");
        LinkedList exp2 = new LinkedList();
        exp2.add(5);
        System.out.println("\ncontainsAll : " + linkedList.containsAll(exp1));
        System.out.println("containsAll : " + linkedList.containsAll(exp2));

        /*get(int)*/
        // 지정된 위치(int)의 객체를 반환한다.
        // 반환타입 : Object
        Object obj = linkedList.get(0);
        System.out.println("\n" + obj.getClass()); // 숫자형 클래스 중에 하나인 Integer가 나옴

        /*indexOf(Object)*/
        // 지정된 "객체의 위치"를 반환, 앞에서부터 수행한다.
        // 반환타입 : int
        addNumber(linkedList);
        int whereIsMyNumber = linkedList.indexOf(2);
        System.out.println("whereIsMyNumber : " + whereIsMyNumber);
        printLinkedList(linkedList, 5);

        /*isEmpty()*/
        // 해당 링크드리스트에 비어있는지 확인한다. 비어있으면 true를 반환한다.
        // 반환타입 : boolean
        exp1.clear();
        System.out.println("\nisEmpty : " + linkedList.isEmpty());
        System.out.println("isEmpty : " + exp1.isEmpty());

        /*lastIndexOf(Object)*/
        // 지정된 "객체의 위치"를 뒤에서 부터 검색한다.
        // 반환타입 : int
        int whereIsMyNumber2 = linkedList.lastIndexOf(2);
        System.out.println("\nwhereIsMyNumber2 : " + whereIsMyNumber2);
        printLinkedList(linkedList, 6);

        /*remove(int), */
        // 지정된 위치(int)의 객체를 제거
        // 반환타입 : Object
        int num = (int) linkedList.remove(0);
        System.out.println("remove : " + num);
        printLinkedList(linkedList, 7);

        /*remove(Object)*/
        // 해당 객체를 제거한다. 성공 시 true값을 반환한다.
        // 반환타입 : boolean
        linkedList.remove(4);
        printLinkedList(linkedList, 8);

        /*removeAll(Collection)*/
        // 지정된 컬렉션의 요소와 "일치하는 요소"를 모두 삭제
        // 반환타입 : boolean
        LinkedList exp3 = new LinkedList();
        addNumber(exp3);
        linkedList.add("난 살지롱");
        linkedList.removeAll(exp3);
        printLinkedList(linkedList, 9);

        /*retainAll(Collection)*/
        // 지정된 컬렉션과 비교하여 "일치하지 않는 데이터"를 삭제한다.
        // 반환타입 : boolean
        LinkedList exp4 = new LinkedList();
        exp4.add("난 살지롱");
        exp4.add("난 죽지롱");
        printLinkedList(exp4, 10);

        System.out.println("\nretainAll 적용(true 일 경우 작동) : " + exp4.retainAll(linkedList));
        printLinkedList(exp4, 11);

        /*set(int, Object)*/
        // 지정된 위치(int)에 지정한 객체(Object)로 변경한다.
        // 반환타입 : Object
        String text = (String) linkedList.set(0, "이걸로 바뀐다!");
        System.out.println("\n기존에 있던 값 : " + "\"" + text + "\"");
        System.out.println("변경된 값 : " + "\"" + linkedList.get(0) + "\"");

        /*subList(int, int)*/
        // 지정된 범위 사이의 객체를 List로 변경한다. int <= 범위 < int
        // 반환타입 : List
        linkedList.clear();
        addNumber(linkedList);
        List list = linkedList.subList(2,4);
        printLinkedList(linkedList, 12); // 기존의 값은 유지가 된다.
        printLinkedList(list, 13);

        /*toArray()*/
        // LinkedList의 객체들을 객체 배열로 반환한다.
        // 반환타입 : Object[]
        Object[] objects = linkedList.toArray();
        System.out.println("toArray를 이용하여 배열생성");
        for (Object o : objects) {
            System.out.println(o);
        }
        printLinkedList(linkedList, 14); // 기존의 배열은 유지된다.

        /*size()*/
        // LinkedList에 "저장된 객체들의 수"를 반환, 길이를 말하는 것이 아니다!
        // 반환타입 : int
        System.out.println("\nsize : " + linkedList.size());

        /*밑에서부터의 메서드들은 Deque에서 상속받은 메서드*/
        /*element()*/
        // LinkedList의 첫 번째 요소를 반환
        // 반환타입 : Object
        linkedList.add(0,"내가 첫번째");
        String text1 = (String) linkedList.element();
        System.out.println("\nelement : " + text1);

        /*offer(Object)*/
        // 지정된 객체를 LinkedList의 끝에 추가, 성공하면 true
        // 반환타입 : boolean
        linkedList.offer("나는 마지막!");
        printLinkedList(linkedList, 15);

        /*peek()*/
        // 첫 번째 요소를 반환한다.
        // 반환타입 : Object
        String str = (String) linkedList.peek();
        System.out.println("\npeek : " +  str);

        /*poll()*/
        // peek처럼 첫 요소를 가져온 뒤 해당 요소를 배열에서 제거한다.
        // 반환타입 : Object
        String str1 = (String) linkedList.poll();
        System.out.println("\npoll : " + str1);
        printLinkedList(linkedList, 16);

        /*remove()*/
        // 기존의 링크드리스트에 있던 remove처럼 제거를 하는 메서드지만 차이점은 해당 메서드는 "첫 요소를 제거한다" 이다.
        // 반환타입 : Object
        int num1 = (int) linkedList.remove();
        System.out.println("\nremove : " + num1);
        printLinkedList(linkedList, 17);

        /*addFirst(Object)*/
        // 맨 앞에 객체를 추가
        // 반환타입 : void
        linkedList.addFirst("이제는 내가 첫째");
        printLinkedList(linkedList, 18);

        /*addLast(Object)*/
        // 맨 뒤에 객체를 추가
        // 반환타입 : void
        linkedList.addLast("이제는 내가 막내");
        printLinkedList(linkedList, 19);

        /*getFirst()*/
        // 맨 앞의 요소를 반환
        // 반환타입 : Object
        /*var는 추측형(?) 변수로 컴파일시 해당 타입으로 변형된다. (몰라도 전혀 상관없음 ㅎ)*/
        var whatsThat1 = linkedList.getFirst();
        System.out.println("\ngetFirst : " + whatsThat1.toString());

        /*getLast()*/
        // 맨 뒤의 요소를 반환
        // 반환타입 : Object
        /*여기서 var를 쓴 이유는 작성자가 뭘 넣었는지 기억못해서임;;*/
        var whatsThat2 = linkedList.getFirst();
        System.out.println("\ngetLast : " + whatsThat2.toString());

        /*offerFirst(Object)*/
        // 맨 앞에 객체를 추가
        // 반환타입 : boolean
        linkedList.offerFirst("내가 첫번째");
        printLinkedList(linkedList, 20);

        /*offerLast(Object)*/
        // 맨 뒤에 객체를 추가
        // 반환타입 : boolean
        linkedList.offerLast("내가 진짜 마지막");
        printLinkedList(linkedList, 21);

        /*peekFirst()*/
        // 첫번째 요소를 반환, 반환 후 배열은 그대로 유지
        // 반환타입 : Object
        var whatsThat3 = linkedList.peekFirst();
        System.out.println("\npeekFirst : " + whatsThat3.toString());

        /*peekLast()*/
        // 마지막 요소를 반환, 반환 후 배열은 그대로 유지
        // 반환타입 : Object
        var whatsThat4 = linkedList.peekLast();
        System.out.println("\npeekLast : " + whatsThat4.toString());

        /*pollFirst()*/
        // 첫 번째 요소를 반환하면서 "배열에서 제거"한다.
        // 반환타입 : Object
        var whatsThat5 = linkedList.pollFirst();
        System.out.println("\npollFirst : " + whatsThat5.toString());
        printLinkedList(linkedList, 22);

        /*pollLast()*/
        // 마지막 요소를 반환하면서 "배열에서 제거"한다.
        // 반환타입 : Object
        var whatsThat6 = linkedList.pollLast();
        System.out.println("\npollLast : " + whatsThat6.toString());
        printLinkedList(linkedList, 23);

        /*removeFirst()*/
        // LinkedList의 첫번째 요소를 제거
        // 반환타입 : Object
        var whatsThat7 = linkedList.removeFirst();
        System.out.println("\nremoveFirst : " + whatsThat7.toString());
        printLinkedList(linkedList, 24);

        /*removeLast()*/
        // LinkedList의 마지막 요소를 제거
        // 반환타입 : Object
        var whatsThat8 = linkedList.removeLast();
        System.out.println("\nremoveFirst : " + whatsThat8.toString());
        printLinkedList(linkedList, 25);

        /*pop()*/
        // removeFirst()와 동일하게 첫 번째 요소를 제거한다.
        // 반환타입 : Object
        var whatsThat9 = linkedList.pop();
        System.out.println("\npop : " + whatsThat9.toString());
        printLinkedList(linkedList, 26);

        /*push(Object)*/
        // addFirst()와 동일하게 맨 앞에 객체를 추가한다.
        // 반환타입 : Object
        linkedList.push("다시 내가 첫번째!!");
        printLinkedList(linkedList, 27);

        /*removeFirstOccurrence(Object)*/
        // LinkedList에서 첫번째로 일치하는 객체를 제거한다.
        // 반환타입 : boolean
        linkedList.clear();
        linkedList.add('a');
        linkedList.add('b');
        linkedList.add('a');
        linkedList.add('c');
        printLinkedList(linkedList, 28);
        System.out.println("removeFirstOccurrence 적용 전\n");
        linkedList.removeFirstOccurrence('a');
        printLinkedList(linkedList, 29);
        System.out.println("removeFirstOccurrence 적용 후\n");

        /*removeLastOccurrence(Object)*/
        // LinkedList에서 마지막으로 일치하는 객체를 제거한다.
        // 반환타입 : boolean
        linkedList.clear();
        linkedList.add('a');
        linkedList.add('b');
        linkedList.add('a');
        linkedList.add('c');
        printLinkedList(linkedList, 28);
        System.out.println("removeLastOccurrence 적용 전\n");
        linkedList.removeLastOccurrence('a');
        printLinkedList(linkedList, 29);
        System.out.println("removeLastOccurrence 적용 후\n");

        // 정리를 하고나니 생각보다 엄청많다;;
        // 순차적으로 사용시에는 ArrayList가 더 뛰어나다
        // 하지만 중간중간에 데이터를 다룰 때에는 LinkedList가 더 뛰어나니
        // 뭐가 더 뛰어난 저장방식이라고 확답은 할수없다.
    }

    static void printLinkedList(List<?> linkedList, int page) {
        System.out.println("\n" + page + "번째 print 메서드 사용!");
        if (linkedList.isEmpty()) {
            System.out.println("해당 LinkedList는 값이 없어요!!!");
        } else {
            for (Object o : linkedList) {
                System.out.println(o);
            }
        }
    }

    static void addNumber(LinkedList linkedList) {
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
    }

}
