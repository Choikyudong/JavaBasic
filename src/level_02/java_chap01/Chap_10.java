package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// 이전에 배웠떤 Arrays의 sort() 메서드를 호출하면 알아서 정렬을 하는 것처럼 보이지만
// 실제로는 Character 클래스의 Comparable의 구현에 의해 정렬이 되었던 것이다.

// Comparator와 Comparable은 인터페이스로 컬렉션을 "정렬"하는데 필요한 메서드를 정의하고 있다.
// Comparable은 클래스들끼리 정렬을 할 수 있도록 도와준다. 즉 기본 정렬기준을 제공
// Comparator는 기본 정렬기준 외에 다른 기준으로 정렬할 때 사용
public class Chap_10 {

    public static void main(String[] args) {
        String[] str =  {"cat", "Dog", "lion", "tiger"};

        // String의 Comparable에 의해서 정렬이 된다.
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));

        // 대소문자 구별없이 정렬
        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(str));

        // 역순 정렬
        Arrays.sort(str, new Example());
        System.out.println(Arrays.toString(str));

    }

    static class Example implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c1.compareTo(c2) * -1; // -1를 곱해서 기본 정렬방식의 역으로 변경한다.
            }
            return -1;
        }
    }

}
