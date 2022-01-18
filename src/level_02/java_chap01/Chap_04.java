package level_02.java_chap01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*자바와 컬렉션프레임워크*/

// Map은 앞서 정리한 List, Set과는 조금 많이 다른 저장방식이다.
// 키(key)와 값(value)를 하나의 쌍으로 묶어서 저장하는 방식인데
// 여기서 키값은 고유의 값으로 중복을 허용하지 않으나
// 값(value)는 중복이 허용이 된다. 만약 키값이 중복이 될 경우에는
// 마지막 키값의 값만이 저장이 된다! <- 중요
// 또한 순서가 존재하지 않는 저장방식이다.
public class Chap_04 {

    // Map은 앞서서 다뤄왔던 List, Set과 다르게
    // Collection이 조상이 아니다. 그렇다고 컬렉션 프레임워크가 아닌것은 아니다.
    public static void main(String[] args) {
        Map map = new Map() {
            // Map에 저장된 key-value 쌍의 개수를 번환한다.
            @Override
            public int size() {
                return 0;
            }

            // Map이 버이었는지 확인한다.
            @Override
            public boolean isEmpty() {
                return false;
            }

            // 지정한 key와 일치하는 key객체가 존재하는지 확인한다.
            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            // 지정한 value와 일치하는 value객체가 존재하는지 확인한다.
            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            // 지정한 key에 해당하는 value값을 찾아서 반환한다.
            @Override
            public Object get(Object key) {
                return null;
            }

            // value객체를 key객체에 연결하여 저장한다. 이것을 "맵핑"한다고 한다.
            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            // 지정한 key값과 일치하는 key-value를 제거한다.
            @Override
            public Object remove(Object key) {
                return null;
            }

            // 지정한 모든 Map에 key-value를 추가한다.
            @Override
            public void putAll(Map m) {

            }

            // Map의 모든 객체를 삭제한다.
            @Override
            public void clear() {

            }

            // Map에 저장된 모든 key객체를 반환한다. (Set 타입인것을 기억하자)
            @Override
            public Set keySet() {
                return null;
            }

            // Map에 저장된 모든 value 객체를 반환한다.
            @Override
            public Collection values() {
                return null;
            }

            // Map에 저장되어 있는 key-value쌍을 Map.Entry타입의 객체로 저장한 Set타입으로 반환한다.
            @Override
            public Set<Entry> entrySet() {
                return null;
            }
        };

        // values()의 반환타입은 Collection이고, KeySet()은 반환타입이 Set이다. (앞에서 다룬 Set이 맞다)
        // Map은 값(value)의 중복은 허용하기 때문에 Collection 타입으로 반환하고
        // 키(key)의 중복은 허용하지 않기 때문에 허용하지 않는 값을 다루는 Set타입으로 반환을 한다.

        /*Map.Entry*/
        /*해당 인터페이스는 Map인터페이스안에 정의된 내부 인터페이스이다. (406번째 라인부터 볼 수 있다.)*/
        /*Map에 저장되는 key-value쌍을 다루기 위해 정의된 인터페이스이다.*/
        Map.Entry entry = new Map.Entry() {

            // Entry의 key 객체를 반환한다.
            @Override
            public Object getKey() {
                return null;
            }

            // Entry의 value객체를 반환한다.
            @Override
            public Object getValue() {
                return null;
            }

            // Entry의 value객체를 지정된 객체로 바꾼다.
            @Override
            public Object setValue(Object value) {
                return null;
            }

            // 동일한 Entry인지 확인한다.
            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            // Entry의 해시코드를 반환한다.
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

    }

}
