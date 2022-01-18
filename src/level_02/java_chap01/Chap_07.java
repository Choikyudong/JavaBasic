package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// Stack과 Queue에 대해서 알아볼껀데 우선 둘의 특징을 알아야한다.
// Stack은 LIFO라고 불리는 시스템으로 마지막에 저장한 값을 먼저 꺼내는 방식이다.
// Queue는 FIFO라고 불리는 시스템으로 처음에 저장한 값을 먼저 꺼내는 방식이다.

/*2개의 특징만 이해했다면 끝이다.*/
public class Chap_07 {

    public static void main(String[] args) {
        // 우선 스택부터 살펴보면 생성은 이렇다.
        Stack stack = new Stack();

        // 스택을 본격적으로 살펴보기전에 스택은 Vector라는 클래스를 상속받아 사용한다.
        // 컬렉션 프레임워크가 탄생하기전에 사용하던 데이터 저장방식으로
        // ArrayList와 정말 많이 비슷하다, 두개의 차이점은 "동기화"여부이다.

        /*empty()*/
        // 해당 Stack이 버이었는지 확인한다.
        // 반환타입 : boolean
        System.out.println("empty : " + stack.empty());

        /*push(Object)*/
        // 지정한 객체를 저장한다. 스택은 위에서 차곡차곡 물건을 올린다고 상상하자.
        // 반환타입 : Object
        stack.push("안녕!");
        stack.push("반가워!");
        System.out.println("스택 출력");
        for (Object o : stack) {
            System.out.println(o);
        }

        /*peek()*/
        // 해당 Stack의 맨 위의 객체를 반환한다. 데이터는 그대로 유지한다.
        // 반환타입 : Object
        System.out.println("\npeek : " + stack.peek());

        /*search(Object)*/
        // 주어진 객체를 찾은 뒤 존재한다면 "위치를 반환", 없을경우 -1
        // 반환타입 : int
        System.out.println("\nsearch : " + stack.search("안녕!"));

        /*여기서부터는 "Queue"*/
        // Queue는 인터페이스로 다양한 구현체가 있는데 여기서는 LinkedList를 사용한다.
        Queue queue = new LinkedList();

        /*offer(Object)*/
        // 지정한 객체를 저장, 성공하면 true
        // 반환타입 : boolean
        queue.offer("Hello");
        queue.offer("Java");
        System.out.println("\n큐 출력");
        for (Object o : queue) {
            System.out.println(o);
        }

        /*add(Object)*/
        // 지정한 객체를 Queue에 추가한다. 성공하면 true 저장공간 부족시 IllegalStateException 발생
        // 반환타입 : boolean
        queue.add("Hello");
        queue.add("World");
        System.out.println("큐 출력");
        for (Object o : queue) {
            System.out.println(o);
        }

        /*peek()*/
        // 삭제없이 요소를 읽어 온다. 비어있으면 null를 반환
        // 반환타입 : Object
        queue.clear();
        System.out.println("\npeek : " + queue.peek());

        /*element()*/
        // 삭제없이 요소를 읽어 온다. peek()와 달리 큐가 비어있다면 "NoSuchElementException"발생
        // 반환타입 : Object
        try {
            queue.element();
        } catch (NoSuchElementException e) {
            System.out.println("\n이렇게 Exception 발생");
        }

        /*poll()*/
        // 큐에서 객체를 꺼내서 반환, 비어있다면 null
        // 반환타입 : Object
        System.out.println("\npoll : " + queue.poll());

        /*remove()*/
        // 큐에서 객체를 꺼내서 반환, 비어있다면 NoSuchElementException 발생
        // 반환타입 : Object
        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("\n이렇게 Exception 발생");
        }

        /*그리고 Queue는 또 다른 구현체가 존재한다.*/
        Queue pq = new PriorityQueue();

        // 해당 컬렉션은 저장한 순서에 관계없이 "우선순위(Priority)가 높은 것부터 꺼낸다"
        // 또한 "Null"를 저장할 수 없다. 저장시 NullPointerException이 발생
        // 그리고 저장공간으로는 "배열"을 사용하며 '힙(Heap)'이라는 자료구조 형태로 저장한다고 한다.

        // 여기서는 간단하게 구경만 하고 넘어간다.
        pq.offer("c");
        pq.offer("a");
        pq.offer("d");
        pq.offer("b");

        // 내부 배열 확인하기
        System.out.println("\n PriorityQueue : " + pq);

        // 저장된 값들을 꺼내보기
        System.out.println("\n PriorityQueue 출력");
        for (Object o : pq) {
            System.out.println(o);
        }
        // 여기서는 간단한 문자 하나만을 비교를 했기 때문에 손쉽게 가능했지만
        // 만약 특정한 객체를 사용한다면 비교방법을 제공해야한다.

        // 또한 해당 클래스의 내부적으로 힙(heap)이라는 자료구조의 형태이기 때문에 이렇게 가능하다고 한다.
        // 구체적인 내용은 다음에 따로 다룰 예정

        // 그리고 Deque이라는 자료구조도 있으나 어렵지 않은 구조이므로 생략을 한다.
        // 간단하게 덱을 설명하면 기존의 큐가 한쪽 방향으로만 자료가 나가고 한쪽으로만 저장이 되는 구조이면
        // 덱은 자료가 나가고 들어오는 쪽이 양방향이라는 것이다.

        /*이렇게 Stack과 Queue의 정리를 끝냄*/

    }

}
