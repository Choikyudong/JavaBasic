package level_01.java_chap01;

// 자바와 if (논리문)

public class Chap_6 {

    // if문은 가장 많이 사용하는 문법 중 하나라고 생각한다.
    // {} <- 블럭이라고 표현한다.
    public static void main(String[] args) {
        int x = 10;
        int y = 5;
        int z = 5;

        /*if ( 조건문 ) <- 으로 사용하면 된다.*/
        if (x > y) { // 조건문이 참, 진실이라면 블럭안에 문장이 실행된다.
            System.out.println("x값이 y값보다 큽니다!");
        }

        if (x < y) { // 거짓이므로 실행이 되지 않는다.
            System.out.println("x는 y보다 작습니다!");
        }

        /*이렇게 비교 연산자를 이용해서 조건문을 많이 사용한다.*/
        if (x == y) {
            System.out.println("x와 y는 같을까요?");
        }

        /*논리 연산자를 추가해서 조금 더 조건문을 다양하게 만들 수 있다.*/
        if (x > y || y > z) { // 이런식으로 할 수 있다.
            System.out.println("x는 y보다 크고 또는 y는 z보다 크다");
        }

        if ((x > y) && (z > y)) { // 괄호로 묶어주면 더 깔끔해 보인다.
            System.out.println("x는 y보다 크며 그리고 z는 y보다 크다");
        }

        if ((x > y) && !(z > y)) { // 또한 부정연산자를 이용해서 참,거짓을 뒤집을 수 있다.
            System.out.println("x는 y보다 크며 그리고 z는 y보다 크다");
        }

        /*또한 블럭을 꼭 안써도 실행하는데 문제는 없다*/
        if (x > y) System.out.println("이렇게도 상관없어요");

        /*중요한건 "if"문의 조건문이 "참"이여야 실행이 된다는 점이다*/

        /*이중 if문*/
        /*if문안에 또 if문을 사용하면 이중 if문이 완성된다.*/
        if (true) { // true 이므로 if문 블럭에 존재하는 코드가 실행된다.
            if (true) { // 또한 true 이므로 if문 블럭에 존재하는 코드가 실행된다.
                System.out.println("이중 if문!");
            }
        }

        /*조금 더 나아가서 if문의 작동방식이 조건문이 true일때만 작동한다면 false일때 작동을 하는 방법도 있다.*/
        if (x < y) { // x == 10, y == 5이므로 false, 즉 조건문은 거짓이다.
            System.out.println("이건 당연히 실행이 안됩니다");
        } else { // 조건문 입력란 없이 else를 입력하면 된다.
            System.out.println("당연히 x가 큽니다.");
        }
        /*오직 if문들이 거짓일때만 발동하는 구문이 바로 else이다*/

        /*여기서 "if문"들이라고 표현을 했는데, 그 말은 if문을 여러개도 가능하다는 이야기다*/
        /*그게 바로 "else if"로써 사용방법은 if문과 같다*/
        if (x > 11) {
            System.out.println("x는 10이므로 해당 조건문은 패스");
        } else if (x >= 10) { // if문과 문법이 거의 같다, 단지 else의 추가와 위치의 차이일뿐
            System.out.println("x는 10이므로 10이상에 해당하는 조건문이 참");
        } else {
            System.out.println("코드는 위에서 아래로 실행되기 때문에 else if에서 끝나면 해당 구분은 실행이 안된다.");
        }

        /*코드는 무조건 위에서 아래로 실행이 되기 때문에 하나의 if문이라도 성공하면 나머지 if문은 실행하지 않는다*/

        // 이제 위에 내용들을 응용해보면 이렇게 쓸 수 있다.
        int month = 4; // 12까지 계절을 입력해보자
        String season;
        if (month == 12 || month == 1 || month == 2) {
            season = "겨울";
        } else if (month == 3 || month == 4 || month == 5) {
            season = "봄";
        } else if (month == 6 || month == 7 || month == 8) {
            season = "여름";
        } else if (month == 9 || month == 10 || month == 11) {
            season = "가을";
        } else {
            season = "이건 무슨 달인가요?";
        }
        System.out.println("계절은 " + season + "입니다!");
    }
}
