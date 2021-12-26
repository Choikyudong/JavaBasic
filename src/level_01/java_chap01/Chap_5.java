// 패키지에 관한 정보는 주석을 제외하고 처음에 입력이 되야한다.
// 해당 클래스는 java_chap1이라는 패키지안에 있다.
package level_01.java_chap01;

/* 접근제어자와 패키지 */

// 자바에서는 다른 패키지에 있는 클래스를 이렇게 가져온다.
import java_forChap.ProtectedClass;

public class Chap_5 extends ProtectedClass {

    // 객체와 클래스에 대하여 조금 더 파고들 시간
    // 자바에는 4개의 접근제어자가 존재한다.
    public static void main(String[] args) {
        SubClass subClass = new SubClass();

        /* private 제어자*/
        // private 제어자는 같은 클래스안에서만 이용이 가능하다.
        //System.out.println(subClass.number1); // <- 궁금하면 주석해제

        /* private 제어자를 이용하기 */
        // 그래서 자바에서 많은 개발자들은 getter, setter라는 개념을 이용한다.
        // 해당 메서드를 이용하는데 이름이 꼭 저런 형식이라는 법칙은 없다.
        System.out.println(subClass.getNumber1()); // 정상적으로 값을 가져올 수 있다.
        
        /* default 제어자 */
        // 우선 default 제어자는 키워드없이 사용하면 그게 default 제어자이다.
        // 기본제어자도 같은 패키지안에서 동작이 가능하다.
        System.out.println(subClass.number2);

        /* protected 제어자*/
        // protected 제어자는 같은 패키지또는 자식클래스(나중에 기술)에서 사용이 가능
        System.out.println(subClass.number3);

        // 다른 패키지에 있는 값을 가져오면
        ProtectedClass protectedClass = new ProtectedClass();
        // 기본제어자와 protected 제어자로는 다른 패키지값을 가져오지 못한다.
        // System.out.println(protectedClass.number1);
        // System.out.println(protectedClass.number2);

        /* public 제어자 */
        // public 제어자는 어디서든 가져올 수 있다.
        System.out.println(protectedClass.number3);
    }

}

class SubClass {
    private int number1 = 5;
    int number2 = 5;
    protected int number3 = 5;

    // getter
    public int getNumber1() {
        return this.number1;
    }

    // setter
    public void setNumber1(int number1) {
        this.number1 = number1;
    }
}

