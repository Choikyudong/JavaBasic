package java_chap1;

// 자바의 기본연산자들 (중요)

public class Chap_4 {
    public static void main(String[] args) {
        /* 산술연산자 */
        // 일반적인 숫자계산이랑 비슷하다.
        int a = 1 + 1; // 1 더하기 1의 값을 a에 저장 -> 2
        int b = 3 * 3; // 3 곱하기 3의 값을 b에 저장 -> 9
        int c = 6 / 3; // 6 나누기 3의 나누는값을 c에 저장 -> 2
        int d = 6 % 3; // 6 나누기 3의 나머지값을 d에 저장 -> 0
        int e = 2 - 1; // 2 빼기 1의 값을 e에 저장 -> 1

        // 대입연산자
        // 자바에서는 이렇게 표현을 할 수 있다.
        a += 1; // a = a + 1과 같다고 생각하면 된다. 밑에도 같음
        b *= 3;
        c /= 165;
        d -= 15;
        e %= 66;

        /* 증감 연산자 */
        int x = 1;
        ++x; // x의 값을 먼저 1만큼 증가시키고 연산을 진행
        x++; // 연산을 수행한 뒤 x의 값을 1만큼 증가
        --x; // x의 값을 먼저 1만큼 감소시키고 연산을 진행
        x--; // 연산을 수행한 뒤 x의 값을 1만큼 감소

        /* 비교 연산자 (중요) */
        // 비교 연산자의 반환값은 boolean타입이다
        int i = 2;
        int y = 1;

        boolean b1 = i == y; // i값과 y값은 같다 -> 같지않으므로 b1은 false 값을 가진다.
        boolean b2 = i != y; // i값과 y값은 같지않다 -> 값이 같지않다는게 사실이므로 b2는 true 값을 가진다.
        boolean b3 = i > y; // i값이 y값보다 크다 -> i값이 큰것이 사실이므로 b3는 true 값을 가진다.
        boolean b4 = i < y; // i값이 y보다 작다 -> i값이 더 크니 b4는 false 값을 가진다.
        boolean b5 = i >= y; // i값이 y보다 크거나 같다 -> 크거나 같다 2개의 경우중에 큰값의 조건에 해당하니 true 값을 가진다.
        boolean b6 = i <= y; // i값이 y보다 작거나 같다 -> 작거나 같다 2개의 경우에 다 만족못하니 false 값을 가진다.

        /* 논리 연산자 (중요) */
        boolean result;
        int number1 = 5;
        int number2 = 3;
        // 예시를 보기전에 논리 연산자는 3가지만 기억하면 된다.
        // && = AND : 논리가 모두 참이면 참을 반환
        // || = OR : 논리가 하나라도 참이면 참을 반환
        // ! = NOT : 논리식이 참이면 거짓, 거짓이면 참을 반환

        //            논리1   그리고    논리2
        result = (number1 > 4) && (number2 < 5); // (5 > 4) and (3 < 5) 두개의 논리가 모두 사실이니 true(참)를 반환

        //            논리1    또는     논리2
        result = (number1 > 7) || (number2 > 2); // (5 > 7)은 7이 더 크므로 안되지만 두번째 논리가 사실이니 true(참)를 반환

        //     부정    논리1     또는     논리2
        result = !((number1 > 7) || (number2 > 2)); // 위의 결과에서 맨앞에 !를 붙이므로써 결과값이 false 로 바꿀 수 있다.

        /* 삼항연산자 */
        int myNumber1, myNumber2; // 이런식으로 선언을 할 수 있다.
        myNumber1 = 5;
        //          논리식 ?   참일때값  :  거짓일때값
        myNumber2 = i > 5 ?  myNumber1 : -myNumber1; // 5보다 크지는 않으니 거짓일때값이 입력이 된다 -> -5

        /* instanceof 연산자 (안중요) */
        // 같은 객체인지 확인하는 연산자이다.
        TestClass_1 t1 = new TestClass_1();
        TestClass_2 t2 = new TestClass_2();

        //                객체 instanceof  비교객체
        System.out.println(t1 instanceof TestClass_1);
        System.out.println(t2 instanceof TestClass_2);
        // 둘 다 같으므로 전부 true 가 나온다.
        // 해당 연산자를 이해하기 위해서는 객체에 대해서 조금 더 공부를 해야한다.
    }
}

class TestClass_1 {

}

class TestClass_2 {

}
