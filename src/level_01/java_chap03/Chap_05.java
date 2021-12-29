package level_01.java_chap03;

// 자바와 객체지향

public class Chap_05 {

    // 앞에까지 생성자와 메서드 그리고 클래스에 즉 객체에 대해서 간단히 정리를 했는데
    // 이제는 객체를 조금 더 응용해야한다.
    public static void main(String[] args) {
        /*이번에는 "상속"이라는 기능을 사용해서 클래스를 사용해보자*/

        /*해당 클래스를 부모(상위)클래스 또는 슈퍼클래스라고 칭한다. (그 외에 다양한 호칭들이 있음)*/
        class ClassA {
            String name = "나는 부모필드값";
            void ImMethod() {
                System.out.println("나는 부모메서드");
            }
        }

        /*"상속"을 사용하는 방법은 "extends"라는 키워드를 사용하고 뒤에 상속받는 클래스를 입력하면 된다.*/
        /*이렇게 "상속"을 받은 클래스를 자식클래스 또는 하위클래스라고 칭한다.*/
        class ClassB extends ClassA {
            /*해당 클래스에는 값이 없습니다.*/
        }

        /*사용방법은 일반적인 클래스와 같다.*/
        ClassB b = new ClassB();

        /*그리고 상속을 받게되면 부모클래스에 있는 필드와 메서드를 그대로 "상속"받게된다.*/
        System.out.println(b.name);
        b.ImMethod();

        /*또한 "상속"에 또 "상속"도 가능하다.*/
        class ClassC extends ClassA {
            /*이렇게 또 받아도 아무런 문제가 없다.*/
        }

        /*이렇게 하위클래스로 사용했던 클래스를 가져와도 맨처음 부모의 값을 가져온다.*/
        class ClassD extends ClassC {}
        ClassD d = new ClassD();
        System.out.println(d.name);
        d.ImMethod();

        /*다만 "상속"은 오직 한가지만 받을 수 있다. (중요)*/
        /*매우매우 중요한 개념이므로 꼭 알아야한다.*/
        /*
        class ClassE extends ClassA, ClassB {
            이렇게는 불가능하다.
        }
        */

        /*이제 상속을 어떻게 하는지에 대해서는 이해를 했다고 생각하고 "상속을 응용"를 해야한다.*/
        /*여기서 중요한 개념인 "오버라이딩"이 나온다. 기능은 부모클래스로 받은 값을 "재정의"하는것이다.*/
        class ClassF extends ClassA {
            String name = "나는 자식F필드값";

            /*@ <- 붙은 것들을 "애너테이션"이라고 말하는데 "애너테이션"이 붙으면 컴파일러가 읽고 확인하는 용도이다.*/
            /*여기서는 "오버라이딩"를 한다는 표시를 하는 애너테이션이 붙었는데 없어도 상관없이 잘 동작한다.*/
            @Override // 웬만하면 붙여줘서 컴파일러가 잘 확인하도록 해주자, 기능상에 불이익도 없다
            void ImMethod() {
                System.out.println("나는 자식F메서드");
            }
        }
        ClassF f = new ClassF();
        System.out.println(f.name);
        f.ImMethod();

        /*값이 새로 정의가 된것을 확인가능하다.*/
        /*여기서 이렇게 생각할 수 있다. ClassF로 인해서 ClassA의 값이 변경된것이 아니냐고*/
        ClassA a = new ClassA();
        System.out.println(a.name);
        a.ImMethod();

        /*확인을 해보면 전혀 변함이 없다는것을 알 수 있다. 이렇게 확인을 하므로써 둘은 같은 값에서 시작하지만*/
        /*결과적으로는 전혀 다른 값을 다루고 있다고 생각하면 된다.*/

        /*그리고 가끔 오버로딩과 오버라이딩이 헷갈린다고 말하는 사람들이 있다.*/
        /*오버로딩은 같은 메서드명을 재정의하는것이고 오버라이딩은 상속받은 내용을 재정의 하는것이다.*/


        /*이제 "super"키워드를 알아보자*/
        /*저번에 "this"키워드에 대해서 들어봤을 것이다. this는 자기자신을 가르치는 키워드이다.*/
        /*super는 상위 클래스를 가르친다.*/
        class ClassG extends ClassA { // 여기서 상위클래스는 ClassA이다.
            void ImMethod() {
                super.ImMethod(); // 이렇게 super 키워드를 붙인다.
                System.out.println("나는 자식G의 메서드");
            }
        }
        ClassG g = new ClassG();
        g.ImMethod();

        /*결과는 2개의 값이 출력이 되는것을 확인할 수 있다.*/
        /*super는 어렵게 생각하지말고 말그대로 상위 클래스의 값을 호출한다고 생각하면된다.*/

        /*조금 더 나아가서 super()를 알아본다. this()는 자기자신의 생성자를 가르치고*/
        /*super()는 상위클래스의 생성자를 가르친다고 생각하자*/
        class ClassH {
            String name;
            ClassH(String name) {
                this.name = name;
            }
        }

        /*여기서 ClassI의 super값은 ClassH의 생성자값을 가르친다.*/
        class ClassI extends ClassH {
            ClassI(String name) {
                super("저는 ClassI입니다.");
            }
        }

        /*모든 상속받은 생성자들에는 저렇게 super()가 들어간다.*/
        /*저번에 생성자도 컴파일러가 없다면 기본적으로 만들어주는것과 마찬가지로 super()를 자동으로 넣어준다.*/

        /*상속파트는 처음 자바를 배우면 머리가 아파지기 시작하는 첫부분이다. 상속의 개념은 어렵지 않으나*/
        /*super키워드랑 이렇게 배운걸 왜? 어디서?가 도저히 이해가 안되기 때문이다.*/
        /*현재부분에서는 사용방법이 정도만 알고넘어가는게 좋다.*/

    }

}
