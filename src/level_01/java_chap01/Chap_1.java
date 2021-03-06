package level_01.java_chap01;

// 자바 기본형 (중요)

public class Chap_1 {

    // <- 자바에서는 이렇게 "주석"을 사용할 수 있다.
    /* 이렇게도 주석을 사용할 수 있다. */
    // 주석이 이렇게 많아도 실행에는 아무 영향도 미치지 않는다.
    // 필요한 이유는 해당 기능에 대하여 짧은 설명을 적음으로써 협업에 도움이 되고
    // 인수인계에도 도움이 되는등등등 주석이 필요하다면 주저없이 입력하자

    // 자바프로그램의 시작점
    // 밑에는 "메인메서드"로 자바를 실행하는 시작점이다.(규칙이자 약속으로 이렇게 입력해야한다)
    public static void main(String[] args) {
        /* 데이터타입   변수명     =    값; */
             int      number     =   25;
        // 이렇게 "a"라는 곳에 25라는 숫자를 저장할 수 있다.
        // 또한 끝에 ;(세미콜론)을 작성해야 한다.
        // 데이터타입은 정해진 타입을 따라서 작성해야하지만
        // 변수명은 규칙안에서 자유롭게 작성이 가능하다.

        /*변수명 규칙*/
        /* 자바에서는 관례적으로 변수명은 소문자로 작성을 한다 */
        /* 지키지않아도 상관은 없지만 협업과 다른 이들을 위하여 지키자 */
        int _abc; // _을 먼저 넣어도 상관없음
        int $abc; // $을 먼저 넣어도 상관없음
        //int 1abc; // 숫자는 먼저 넣으면 안됨;
        //int int; // 자바에서 미리 사용하는 "예약어"는 불가능
        int Number = 25; // 자바에서는 "대소문자"를 구별한다.
        //int Num ber = 25; // 공백은 포함할 수 없다.

        /* 데이터타입  변수명 */
             int     number1;
        //이런식으로 "선언"만 할 수 있다.

        //"선언"된 변수에 이렇게 숫자를 저장할 수 있다.
            number1 = 5;

        /*자바 기본타입 정수형*/
        // byte의 최대범위는 -128 ~ 127, 저장공간은 1byte
        byte b = 127;
        // short의 최대범위는 -32,768 ~ 32,767, 저장공간은 2byte
        short s = 32767;
        // int의 최대범위는 –21억 ~ 21억, 저장공간은 4byte
        int i = 2100000000;
        // long의 최대범위는 -900경 ~ 900경, 저장공간은 8byte, 뒤에 L을 붙여서 long타입을 나타낸다.
        long l = 9000000000000000000L;

        /*자바 기본타입 실수형*/
        // float은 소수점 7자리까지 표현
        float f = 3.4000f;
        // double은 소수점 16자리까지 표현
        double d = 3.4984d;

        /*자바 기본타입 문자형*/
        char c = 'c'; // 문자형으로 ''으로 딱 하나의 문자를 넣을 수 있다.
        char abc = '곽'; // 변수명은 상관없이 입력이 가능하다.
        //char example = 'abc'; // 여러개의 문자를 넣으면 에러가 발생한다.

        /*자바 기본타입 불리언*/
        boolean bool1 = true;
        boolean bool2 = false;
        // boolean형은 참, 거짓을 판별해주는 값을 주는 타입이다.

        /*
        *   결론
        *   1. 변수타입 변수명 = 타입에맞는값; 으로 변수작성 가능
        *   2. 세미콜론은 마지막에 꼭 작성
        *   3. 자바의 기본형은 총 8개가 존재한다.
        *   int, long, short, byte 는 정수형 숫자를 담당
        *   double, float 은 실수형 담당
        *   char 는 문자담당
        *   boolean 은 참, 거짓을 판별해주는 값을 담당한다.
        */
    }
    
}
