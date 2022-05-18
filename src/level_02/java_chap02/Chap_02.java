package level_02.java_chap02;

import java.util.ArrayList;
import java.util.List;

/*지네릭스(Generics)*/
public class Chap_02 {

    /*우선 용어 부터 알아보고 시작하자.*/
    static class Generics<T> { // 이런 지네릭스 클래스가 존재할 때
        // Generics : 원시 타입(raw type)
        // T : 타입 변수 또는 타입 매개변수
        // Generics<T> : 지네릭 클래스, T의 Generics 또는 T Generics라고 읽는다고 한다.

        /*지네릭스에서 불가능한 것들*/
        // static멤버는 사용이 불가능하다,
        // static T value;
        // 이유는 타입이 지정했거나 대입했거나 똑같이 작동해야하는 static 멤버의 특성때문이다.

        T[] valueArr; // 배열의 선언에는 문제없다.
        // public void makeArr() {
        //     this.valueArr = new T[valueArr.length];
        // }
        // 다만 지네릭스로 배열을 생성은 불가능하다.
        // new연산자가 컴파일 시점에 T가 무엇인지 명확히 알아야하는 특성이 있어서 그렇다.
        // 만약 구현하고 싶다면 Reflection을 이용하거나 Object[]를 이용해보자
    }

    static class TestClass<T> {
        T value;
        public void setValue(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // 우선적으로 지네릭스는 제한이 있다.
        // 이게 무슨 말이냐면.. 지네릭스로 클래스타입을 정해서 생성시 정해진 클래스 타입만 넣을 수 있다.
        TestClass<String> stringTest = new TestClass<>();
        TestClass<Integer> integerTest = new TestClass<>();
        // 보다시피 TestClass는 같은 클래스이다 하지만 첫번째 클래스에는 오직 String클래스만
        // 두번쨰 클래스에는 Integer클래스만 넣을 수 있다. 지네릭스는 이렇게 사용하기 위해서 탄생이 되었다.

        /*참고로 1.7버전까지는 생성자에도 타입을 지정을 해야했다고 한다.*/
        TestClass<String> stringTest2 = new TestClass<String>(); // 현재는 안넣어줘도 알아서 넣어준다.

        stringTest.setValue("나는 문자열");
        integerTest.setValue(1000);

        System.out.println(stringTest.getValue());
        System.out.println(integerTest.getValue());

        // 이런식으로 가능할 거 같지만 불가능하다.
        /* TestClass<String> stringToInteger = new TestClass<Integer>(); */
        // 클래스에 들어가는 참조변수와 생성자에 들어가는 참조변수의 값은 무조건 일치해야한다.
        
        /*조금 더 구체적으로 살펴보자, 밑의 클래스 코드를 참고*/
        Box<FirstClass> firstClassBox = new Box<FirstClass>();
        Box<SecondClass> secondClassBox = new Box<SecondClass>();
        // Box<FirstClass> fail1 = new Box<SecondClass>(); 될거 같아 보이지만 이렇게는 안된다.
        Box<WhatisClass> fail2  = new Box<>();

        firstClassBox.add(new SecondClass()); // 상속받은 클래스이니 당연히 된다.
        // secondClassBox.add(new FirstClass()); 이렇게도 안된다.
        // secondClassBox.add(new WhatisClass()); 해당 클래스에는 해당 타입이 아니므로 되지 않는다.

        // 밑의 AllBox부분을 참고하자
        AllBox<SecondClass> firstClassAllBox = new AllBox<>();
        // AllBox<WhatisClass> whatisClassAllBox = new AllBox<WhatisClass>(); 상속받지 못한 클래스는 사용하지 못한다.

    }

    // 이렇게 지네릭스에다가 "extends"를 이용해서 받고싶은 클래스를 상속받으면 된다.
    static class AllBox<T extends FirstClass> extends Box<T> {}
    // 만약 인터페이스도 구현해야 한다면 &로 연결한다.
    static class AnotherBox<T extends FirstClass & Test> extends Box<T> {}

}

class FirstClass {
    @Override
    public String toString() {
        return "나는 부모 클래스!";
    }
}

class SecondClass extends FirstClass {
    @Override
    public String toString() {
        return "나는 상속받은 놈";
    }
}

class WhatisClass {
    @Override
    public String toString() {
        return "난 없음";
    }
}

class Box<T> {
    List<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);
    }
}

interface Test {

}