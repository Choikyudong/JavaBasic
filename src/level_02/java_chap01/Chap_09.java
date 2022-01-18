package level_02.java_chap01;

import java.util.*;

/*자바와 컬렉션프레임워크*/
// Arrays 클래스
// 해당 클래스는 배열을 조금 더 쉽게 다루도록 만든 클래스이다.
// 지금까지 공부한 컬렉션이 아닌 "배열"이다.
public class Chap_09 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};

        /*copyOf([], int)*/
        // 첫번째 파라미터에는 복사를 희망하는 배열, 두번째 파라미터에는 범위를 입력하면 된다.
        // 반환타입 : 타입[]
        int[] copy1 = Arrays.copyOf(arr, arr.length);
        int[] copy2 = Arrays.copyOf(arr, 2);

        /*copyOfRange([], int, int)*/
        // 지정한의 배열의 범위를 복사한다. 두번째 int는 시작값 세번째 int는 범위에 포함하지 않는다.
        // 반환타입 : 타입[]
        int[] copy3 = Arrays.copyOfRange(arr, 2, arr.length);

        /*toString([])*/
        // 배열의 모든 요소를 "문자열"로 변경한다.
        // 반환타입 : String
        /*기존에는 이렇게 배열을 출력했다.*/
        System.out.println();
        for (int i : copy1) {
            System.out.print(i + " ");
        }
        /*이제는 간단한 배열을 손쉽게 출력하자*/
        System.out.println(Arrays.toString(copy2));
        System.out.println(Arrays.toString(copy3));

        /*fill([], 기본타입값), fill([], int, int, 기본타입값)*/
        // 배열의 모든 요소를 지정된 값(기본타입)으로 채운다. 변경할 범위는 선택값이다.
        // 반환타입 : void
        Arrays.fill(copy1, 777);
        Arrays.fill(copy2, 1, 2, 100);
        Arrays.fill(copy3, 0, 1, 10);
        System.out.println(Arrays.toString(copy1));
        System.out.println(Arrays.toString(copy2));
        System.out.println(Arrays.toString(copy3));

        /*sort([]), sort([], int, int)*/
        // 배열을 정렬한다. 또는 지정된 범위만 정렬이 가능하다.
        // 반환타입 : void
        int[] ex1 = {4, 1, 7, 10, 6};
        int[] ex2 = {11, 9, 1, 3, 5};
        Arrays.sort(ex1);
        Arrays.sort(ex2, 1, 4);
        System.out.println(Arrays.toString(ex1));
        System.out.println(Arrays.toString(ex2));

        /*binarySearch([], key), binarySearch([], int, int, key)*/
        // "정렬된 배열"에 목표값(key)의 "위치"를 검색한다. 원한다면 범위를 설정할 수 있다.
        // 반환타입 : int
        int[] ex3 = makeRandomArr();
        System.out.println(Arrays.toString(ex3));
        // 범위에 없다면 음수로 나오며, 중복값이 존재할 경우 무작위의 위치가 나온다.
        System.out.println(Arrays.binarySearch(ex3, 5));
        // 위의 기법은 검색알고리즘의 종류 중 하나인 "이진검색"을 간단하게 구현을 한 예시이다.

        /*equals([], [])*/
        // 2개의 배열을 비교하여 요소가 같다면 true, 다르다면 false를 반환한다.
        // 반환타입 : boolean
        int[] equlas1 = new int[]{1, 3, 4};
        int[] equlas2 = new int[]{1, 3, 4};
//        int[] equlas2 = new int[]{1, 4};
        System.out.println(Arrays.equals(equlas1, equlas2));

        /*asList([]), asList([],)*/
        // 배열을 List타입으로 변경한다.
        // 반환타입 : List
        List list = Arrays.asList(equlas1);
        //list.add(6); 다만 위처럼 변경할 경우 구현체가 확실하지 않아서 변경이 불가능하다.
        List list2 = new ArrayList(Arrays.asList(equlas1));
        list.add(6); // 이렇게 구현체를 이용해서 넣으면 문제없다.


        // 이 외에도 Arrays에는 다양한 메서드들이 존재하는데
        // 예를들면 deep이 붙은 메서드들은 "다중배열"을 위한 용도이며
        // spliterator()는 다중 쓰레드를 위한 작업 등
        // 여기서는 일반적으로 사용하기 좋은 메서드들만 보고 넘어간다.

    }

    static int[] makeRandomArr() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        Arrays.sort(arr);
        return arr;
    }

}
