package level_02.java_chap01;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/*자바와 컬렉션프레임워크*/
// List와 마찬가지로 Collection에서 파생되는 또 다른 인터페이스 Set이다.
public class Chap_03 {

    // Set은 "중복 허용 금지, 순서가 없는 저장 방식이다."
    // 이제는 List와 Set의 차이점을 꼭 알아야 한다.
    public static void main(String[] args) {
        // Set 또한 인터페이스이다.
        Set set = new Set() {
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
            // 지정한 객체가 존재하는 확인
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
            //지정된 배열에 "컬렉션 객체"를 저장해서 반환
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
            // 컬렉션 객체들을 컬렉션에 추가한다.
            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            /*Collection 상속받음*/
            // 해당 메서드로 컬렉션에 변화가 있다면 true, 없다면 false를 반환한다.
            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            /*Collection 상속받음*/
            // 컬렉션에 포함된 객체들을 삭제한다.
            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            /*Collection 상속받음*/
            // 컬렉션의 모든 객체를 삭제한다.
            @Override
            public void clear() {

            }

        };

        // Set같은 경우는 기존의 Collection 인터페이스와 다른 점은 보이지 않는다.
        // Set의 구현체로는 HashSet, TreeSet 등이 있다.

    }

}
