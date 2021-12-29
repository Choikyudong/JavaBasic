package level_01.java_chap03;

// 상속과 추상클래스

import java.util.ArrayList;

public class Chap_06 {

    // 조금 어려운 부분인 "추상"클래스 파트이다.
    // 그래도 추상파트랑 다음에 나올 인터페이스 부분만 제대로 익혀두면
    // 객체지향설계시 조금 더 멋지게 설계할 수 있다.
    public static void main(String[] args) {

        /*우선 객체지향 설계시 많은 사람들이 중요시 여기는 부분이 바로*/
        /*"추상화"이다. 쉽게 생각하면 강철틀을 만들고 원할 떄 마다 붕어빵, 피자빵, 바나나빵 등*/
        /*각 빵들에 대한 공통적인 부분들을 정의하고 필요한 빵에 쉽게 적용시키기는 것이다.*/

        /*조금 더 쉽게 표현하면 "미완성 설계도"를 제작하는 것이다.*/
        /*"추상"클래스는 아래와 같이 만든다.*/
        abstract class AbstractClass { // abstract <- 이거 하나만 붙이면 추상화가 된다.
            /*abstract키워드를 붙여서 "추상메서드"를 만들 수 있다.*/
            abstract void method1();
            /*참고로 private 제어자는 사용을 못하는데 이유는 상속을 통해서 구현이 되는 특성을 막기 때문이다.*/
        }
        
        /*겉보기에는 일반적인 클래스와 다를게 없으나 막상 바로 사용할려면 사용할 수 없다.*/

        /* 혹시 이렇게 구현하면  되는거 아닌가?라고 생각할 수 있다.
           하지만 해당 방법은 "익명클래스"라고 일회용으로 사용하는 클래스이다. 익명이므로 생성자는 존재하지 않는다.
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            void method1() {
                System.out.println("하이");
            }
        };
        */

        /*본론으로 돌아가서 추상클래스를 제대로 사용하기 위해서는 앞에서 배운 extends로 "상속"을 받아야한다.*/
        class ImClass extends AbstractClass {
            @Override
            void method1() {
                System.out.println("추상메서드는 이렇게 꼭 구현을 해줘야한다!");
            }
        }

        /*"상속"과 크게 다를껀 없다.*/
        ImClass imClass = new ImClass();
        imClass.method1();

        /*이렇게 추상클래스나 상속이라는 개념을 통해서 우리가 얻고자 하는 것은 "다형성"이라는 개념이다.*/
        /*객체지향에서 중요한 개념중 하나이므로 꼭 알고가야한다.*/

        /*예를들어 이런 객체들이 있다고 생각해보자. 동물예시가 제일 좋은듯*/
        /*아래처럼 동물들의 개념이 정의되었다고 생각해보자.*/
        abstract class Animal {
            abstract void sound(); // 동물이 소리낸다.
            abstract void move(); // 동물이 움직인다.
        }

        /*다양한 동물들이 있겠지만 여기서는 고양이, 개 2마리를 예시로 해보면 이렇게 된다.*/
        class Dog extends Animal{
            @Override
            void sound() {
                System.out.println("멍멍");
            }
            @Override
            void move() {
                System.out.println("개가 움직인다.");
            }
        }
        class Cat extends Animal{
            @Override
            void sound() {
                System.out.println("야옹");
            }
            @Override
            void move() {
                System.out.println("고양이가 움직인다.");
            }
        }

        /*그리고 이렇게 사용하면 된다.*/
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.sound();
        cat.sound();

        /*다형성이라는 개념은 하나의 타입이 여러개의 형태를 가지는 것이다. 다형성을 적용시켜보자.*/
        Animal dog2 = new Dog();
        Animal cat2 = new Cat();
        dog2.move();
        cat2.move();

        /*이렇게 2개의 객체들은 Animal이라는 추상클래스를 통해서 구체화 되었기 때문에 둘다 타입을 Animal로 가져올수있다.*/
        /*위의 예시에서는 크게 와닫지 않겠지만 다형성을 통한 장정은 우리가 정의해둔 메서드 또는 필드값을 통해서*/
        /*하위클래스(구현체)를 조작할 수 있다는 것이다.*/

        /*아직까지 "다형성"을 통해서 어떤점이 좋은지 크게 감이 안오는게 정상이니까 걱정을 안하는것이 좋다.*/

        /*개인적으로는 "추상클래스"를 딱히 좋아하지는 않는다. 다음장에 배울기능이 추상클래스의 대부분을 대체가 가능하며*/
        /*추상클래스도 결국은 클래스이며 클래스를 통해서 기능을 확장하는 방법은 "상속" 하나인데*/
        /*상속의 단점이 오직 한가지만 받을 수 있다는 것이다.*/

    }

}
