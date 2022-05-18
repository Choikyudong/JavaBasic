package level_03.java_chap04;

import java_forChap.reflection.obj2.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <h1>자바 리플렉션 - 2</h1>
 * 기초적인 리플렉션에서 이제 조금 더 응용을 해보는 단계
 */
public class Chap_02 {

    public static void main(String[] args) throws Exception {
        // 리플렉션에서 해당 클래스에 접근하기 위해서는 Class 객체를 사용한다.
        Class<Cat> catClass = Cat.class;

        // 매개변수에 맞는 생성자를 하나 가져온다.
        Constructor<Cat> constructor = catClass.getConstructor(String.class, int.class, boolean.class);

        // 입력한 매개변수로 새로운 인스턴스를 만든다.
        Cat newCat = constructor.newInstance("꼬양이", 5, false);

        // 정상적으로 생성자가 생성되었고 확인도 가능하다.
        System.out.println(newCat);

        // 메서드이름을 넣어서 가져온다.
        Method meowMethod = catClass.getMethod("meow");
        meowMethod.invoke(newCat);

        Method punchMethod = catClass.getDeclaredMethod("punch");
        punchMethod.invoke(newCat);

        // Method snickMehthod = catClass.getDeclaredMethod("snick");
        // snickMehthod.invoke(catClass);
        /*
         * public이 아닌 메서드를 부를 경우 접근 에러가 발생한다.
         *
         * 여기서 조금 당황할 수 있다. 왜냐면 바로 앞 챕터에서는
         * private method의 정보를 가져올 수 있는데
         * 막상 실행은 안되니까 말이다.
         */

        System.out.println("------------------------------------------------------");

        Method[] methods = catClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                System.out.println(method.invoke(newCat));
            }
        }
        /*
         * 위의 과정을 평소대로 사용한다면 아래와 같다.
         * Cat cat = new Cat("꼬양이", 5, true);
         * cat.meow();
         * cat.punch();
         */

        System.out.println("--------------------------------------------");
        // 우선 밑의 필드값을 변경하기전에 기존의 필드값을 확인하자
        System.out.println(newCat);

        // 이제 필드를 사용해보자, 우선 원하는 필드값을 선택한다.
        Field ageField = catClass.getDeclaredField("name");
        ageField.setAccessible(true);
        ageField.set(newCat, "구양이");

        // 결과를 보면 변경이 된 것을 알 수 있다.
        System.out.println(newCat);

    }

}
