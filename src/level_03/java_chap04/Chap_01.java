package level_03.java_chap04;

import java_forChap.reflection.obj1.Dog;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * <h1>자바 리플렉션</h1>
 *
 * 자바 리플렉션은 못들어본 사람도 꽤 있는 자바 기본 API이다. <br/>
 * 해당 API의 가장 큰 특징은 "정적"인 소스를 "동적"으로 사용 가능하게 해준다.<br/>
 *  <br/>
 * 조금 더 풀어서 설명하면 구체적으로 클래스 타입을 몰라도 메서드, 타입, 변수에<br/>
 * 접근할 수 있도록 도와주는 API이다.<br/>
 *
 * 동적으로 무언가를 한다는 것이 뭐가 그리 대단하고 필요한지 못 느낄 수 있는데<br/>
 * 정적인 컴파일 언어들을 단 하나의 API로 변경이 가능하다.<br/>
 * <br/>
 * 리플렉션을 배움으로써 조금 더 폭 넓은 자바 코딩이 가능해질 수 있다.<br/>
 * 또한 리플렉션은 자바에서 기본적으로 제공하는 API이기 때문에<br/>
 * 라이브러리에 추가할 필요가 없다는 것도 큰 장점이다.
 *
 */
public class Chap_01 {

    /**
     *  <h3>리플렉션에서 가져올 수 있는 정보는 다음과 같다.</h3>
     *  1. Class<br/>
     *  2. Constructor(생성자)<br/>
     *  3. Method<br/>
     *  4. Field<br/>
     */
    public static void main(String[] args) {
        // 클래스.class 로 해당 클래스를 가져올 수 있다.
        //Class<? extends Dog> dogClass = Dog.class;

        // 클래스를 가져오면 해당 클래스의 정보를 볼 수 있다.
        //System.out.println(dogClass.getName());

        // 인스턴스를 가져오려면 이렇게 하면 된다.
        Dog dog = new Dog("나쁜강아쥐", 99);
        Class<? extends Dog> dogClass =  dog.getClass();

        // 해당 인스터스의 클래스의 정보를 볼 수 있다.
        System.out.println(dogClass.getName());
        System.out.println(dogClass.isArray());

        // 본격적으로 리플렉션의 클래스와 메서드를 이용해서 정보를 가져오자.
        // Constructor는 말그대로 생성자와 관련된 클래스이다.
        Constructor[] constructors = dogClass.getConstructors();

        // 해당 클래스의 생성자들의 정보를 가져와 출력한다.
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() > 0) {
                Parameter[] parameters = constructor.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getName() + " : " + parameter.getType());
                }
            }
        }
        System.out.println("\n--------콘솔 정리---------\n");

        // 이제 메서드의 정보를 들고 올껀데 대표적으로 2개의 메서드를 이용할 수 있다.
        Method[] methods1 = dogClass.getMethods();
        Method[] methods2 = dogClass.getDeclaredMethods();

        // getMethods()
        Arrays.stream(methods1).forEachOrdered(System.out::println);
        System.out.println("\n--------콘솔 정리---------\n");
        // getDeclaredMethods()
        Arrays.stream(methods2).forEachOrdered(System.out::println);

        /*
         * 출력된 결과를 보면 getMethods()는 public 형식에 상위 객체의 모든 메서드를 전부 들고온다.
         * getDeclaredMethods()는 모든 형식에 해당 클래스의 메서드만 들고온다.
         *
         * 이 차이점을 알고 시작하자.
         */
        System.out.println("\n--------콘솔 정리---------\n");
        for (int i = 0; i < methods2.length; i++) {
            System.out.println("메서드 " + (i + 1) + "번째 : " +
                    Modifier.toString(methods2[i].getModifiers()) + " "  + methods2[i].getName() +
                    " -> " + Arrays.toString(methods2[i].getParameterTypes()));
        }

        System.out.println("\n--------콘솔 정리---------\n");
        /*
         * 필드값 또한 2가지 형식으로 가져온다.
         * 가져오는 값만 달라졌을 뿐 행동은 같다.
         */
        Field[] fields1 = dogClass.getFields();
        Field[] fields2 = dogClass.getDeclaredFields();

        for (Field field : fields1) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }

        System.out.println("\n--------콘솔 정리---------\n");

        for (Field field : fields2) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }

        /*
         * 기본적인 리플렉션 코드들을 살펴봤는데
         * 아직까지는 리플렉션을 통해서 정확히 어떤것을 할 수 있을지
         * 감이 안오는것이 이상한 것이 아니다.
         *
         * 조금씩 익히다 보면 왜 리플렉션을 알아야 하는지 알게된다.
         */

    }

}

