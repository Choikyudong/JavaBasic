package level_01.java_chap01;

// 메서드와 클래스

public class Chap_3 {

    // void "키워드"는 반환값이 없을 때 사용하는 키워드이다.
    public static void main(String[] args) {
        // 메소드를 사용하기 위해서도 결국은
        // 클래스가 필요하므로 클래스를 생성한다.(인스턴스화)
        Chap_3 chap_3 = new Chap_3();

        // 변수를 부르는것과 같이 "."으로 호출하면 된다.
        chap_3.method_1();
        chap_3.method_2(5); // 파라미터에 맞춰서 값을 넣어줘야한다.
        chap_3.method_3(true);
    }

    // 메소드란 클래스 "내부"에 정의가 되어있는 기능이라고 생각하자.
    /*생성방법*/
    // 반환타입 메서드이름 파라미터공간
        void   method_1      ()     { // 메소드 이름은 소문자로 시작하는것이 규칙
        // 메소드 실행시 수행하고 싶은 코드들 넣으면 된다.
        System.out.println("이렇게");
    }

    // 파라미터란 메서드에 들어가는 값을 말한다.
    /* 예시 */
    // 반환타입에 int가 있으므로 int값을 돌려줘야한다
    int method_2(int number) { // () <- 안에 들어가는 값이 파라미터라고 생각
        return number; // return을 이용하면 값을 돌려줄 수 있다.
    }

    // 꼭 파라미터 타입으로 반환해라는 규칙은 없다.
    char method_3(boolean bool) {
        method_4(); // 메소드안에 메소드도 상관없다.
        if (bool) { // 사용방법은 후에 기재할 예정
            return 'A';
        }
        return 'B';
    }

    void method_4() {
        System.out.println("응용");
    }

}
