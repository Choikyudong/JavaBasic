package level_02.java_chap01;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*자바와 컬렉션프레임워크*/
// 이제는 Collection에서 조금 더 구체적으로 구현된 것 중에 하나인 List를 알아보자
public class Chap_02 {

    // List는 "중복을 허용, 순서대로 저장을 구현하는 용도"라고 생각하자.
    public static void main(String[] args) {
        // List 또한 인터페이스이므로 이렇게 사용은 하지 않는다.
        // 여기서는 학습을 위해서 이런식으로 입력을 했다.
        List list = new List() {

            /*Collection 상속받음*/
            // 저장된 객체의 개수를 반환
            @Override
            public int size() {
                return 0;
            }

            /*Collection 상속받음*/
            // 컬렉션이 비어있는지 확인
            @Override
            public boolean isEmpty() {
                return false;
            }

            /*Collection 상속받음*/
            // 지정한 객체가 존재하는지 확인
            @Override
            public boolean contains(Object o) {
                return false;
            }

            /*Collection 상속받음*/
            // Iterator를 얻어서 반환한다.
            @Override
            public Iterator iterator() {
                return null;
            }

            /*Collection 상속받음*/
            // 지정된 객체를 "객체배열"로 반환한다.
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            /*Collection 상속받음*/
            // 지정된 배열에 "컬렉션 객체"를 저장해서 반환
            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            /*Collection 상속받음*/
            // 지정된 객체를 컬렉션에 추가
            @Override
            public boolean add(Object o) {
                return false;
            }

            /*Collection 상속받음*/
            // 지정된 객체를 컬렉션에서 제거
            @Override
            public boolean remove(Object o) {
                return false;
            }

            /*Collection 상속받음*/
            // 컬렉션 객체들이 포함이 되어있는지 확인
            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            /*Collection 상속받음*/
            // 켈렉션 객체들을 컬렉션에 추가해준다.
            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            /*List 정의*/
            // 지정된 위치에 컬렉션 객체를 추가한다.
            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            /*Collection 상속받음*/
            // 컬렉션에 포함된 객체들을 삭제한다.
            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            /*Collection 상속받음*/
            // 지정된 컬렉션만 남기고 다른 객체들은 삭제한다.
            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            /*Collection 상속받음*/
            // 컬렉션의 모든 객체를 삭제한다.
            @Override
            public void clear() {

            }

            /*List 정의*/
            // 지정된 위치의 객체를 반환한다.
            @Override
            public Object get(int index) {
                return null;
            }

            /*List 정의*/
            // 지정된 위치에 객체를 저장한다.
            @Override
            public Object set(int index, Object element) {
                return null;
            }

            /*List 정의*/
            // 지정된 위치에 객체를 저장한다.
            @Override
            public void add(int index, Object element) {

            }

            /*List 정의*/
            // 지정된 위치의 객체를 삭제하고 해당 객체를 반환한다.
            @Override
            public Object remove(int index) {
                return null;
            }

            /*List 정의*/
            // 지정된 객체의 "위치"를 반환한다. (첫번째 요소부터 찾음)
            @Override
            public int indexOf(Object o) {
                return 0;
            }

            /*List 정의*/
            // 지정된 객체의 위치를 반환한다. (마지막 요소부터 찾음)
            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            /*List 정의*/
            // List 객체에 접근할 수 있는 ListIterator를 반환한다.
            @Override
            public ListIterator listIterator() {
                return null;
            }

            /*List 정의*/
            // List 객체에 접근할 수 있는 ListIterator를 반환한다.
            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            /*List 정의*/
            // "지정된 범위"에 있는 객체를 반환한다.
            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }

        };

        // 보면 Collection에서 상속된 메서드들이 많다는 것을 알 수 있다.
    }

}
