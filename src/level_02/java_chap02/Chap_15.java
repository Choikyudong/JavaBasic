package level_02.java_chap02;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 스트림7
 * 최종연산의 부분이 좀 많아서 끊어서 쓰는중
 */
public class Chap_15 {

    public static void main(String[] args) {

        /**
         * collect()
         * 스트림의 최종 연산에서 가장 많이 사용되고 유용하면서 복잡한 메서드라고 한다.
         * reduce()와 유사하다. reduce()가 스트림을 소모를 하면서 진행을 한다면
         * collect()는 요소를 수집을 하면서 진행을 하는데 여기서 컬렉터(collector)를 통해서
         * 어떻게 수집을 할 것인가를 정해서 진행을 한다고 한다.
         *
         * 여기서 컬렉터는 인터페이스로 따로 구현이 되어있다고 한다.
         *
         * 용어 정리
         * collect() : 스트림의 최종연산 중 하나로, 매개변수로 컬렉터를 필요로 한다.
         * Collector : 인터페이스로 컬렉터는 해당 인터페이스를 구현해야한다.
         * Collectors : 클래스로 static 메서드로 미리 작성된 컬렉터를 제공한다.
         */
        
        // 예시용 데이터
        MyObj[] myObjs = {
            new MyObj("홍길동", 26, 'A', true),
            new MyObj("김규동", 50, 'B', false),
            new MyObj("아파요", 19, 'A', false),
            new MyObj("이민규", 36, 'C', true),
            new MyObj("팽한우", 41, 'C', true),
        };

        /* 스트림을 기존의 데이터형식으로 가공하는 방법 */
        // toList() : 스트림을 List로 변환
        // 해당 배열에서 이름만 빼오기
        List<String> names = Stream.of(myObjs).map(MyObj::getName).collect(Collectors.toList());
        System.out.println(names);
        
        // toMap() : 스트림을 맵타입으로 변경
        Map<Character, MyObj> mapType = Stream.of(myObjs).collect(Collectors.toMap(MyObj::getGrade, obj -> obj));

        /* 이 외에도 toArray, toCollection, toSet 등이 있따. */

        /** 
         * 이 외에도 counting(), maxBy() 등과 같은 통계를 내는 메서드가 있다.
         * 이것들은 groupingBy(), partitioningBy() 두개를 이용하면서 익혀보자
         * partitioningBy()는 Predicate, groupingBy()는 Function을 이용한다.
         */
        // true를 남자, false를 여자라고 가정을 하고 수행해보자
        List<MyObj> test1 = Arrays.stream(myObjs).collect(Collectors.toList());
        // 입력해둔 불리언으로 데이터를 분할한다.
        Map<Boolean, List<MyObj>> test2 = test1.stream().collect(Collectors.partitioningBy(MyObj::getGender));

        // true를 키값으로 잡으면 남자의 값을
        List<MyObj> test3 = test2.get(true);

        // false로 키값을 주고 counting()을 이용해서 여자의 수를 알아보자. 숫자니 Long을 넣자
        Map<Boolean, Long> test4 = test1.stream().collect(Collectors.partitioningBy(MyObj::getGender, Collectors.counting()));
        long result1 = test4.get(false);

        // 최대 나이를 가진 남자를 뽑아보자
        Map<Boolean, Optional<MyObj>> compareToAge = Stream.of(myObjs)
                .collect(Collectors.partitioningBy(MyObj::getGender,Collectors.maxBy(Comparator.comparingInt(MyObj::getAge))));
        System.out.println(compareToAge.get(true));

        // 30미만을 쳐내자
        Map<Boolean, Map<Boolean, List<MyObj>>> compareToGrade = Stream.of(myObjs)
                .collect(Collectors.partitioningBy(MyObj::getGender,
                            Collectors.partitioningBy(obj -> obj.getAge() > 30)
                        )
                );

        /* groupingBy()는 partitioningBy()와 다르게 기준점을 만들고 시작한다. */
        // Grade 필드값을 기준점으로 잡고 나눈다.
        Map<Character, List<MyObj>> sortByGrade = Stream.of(myObjs)
                .collect(Collectors.groupingBy(MyObj::getGrade));
        System.out.println(sortByGrade.get('A'));

        /* 하다가 토 나올꺼 같아서 일단은 멈추고 담장으로 넘어감;;; */

    }

}

class MyObj {
    String name;
    int age;
    char grade;
    boolean gender;

    MyObj(String name, int age, char grade, boolean gender) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MyObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

}