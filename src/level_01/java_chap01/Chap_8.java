package level_01.java_chap01;


// 자바와 While

public class Chap_8 {

    // for 와 함께 "반복문"인 while이다.
    public static void main(String[] args) {
        /*문법은 조건식이 참(진실)이면 블럭내에 코드가 무한반복이다.*/
        /*
        while (조건식) {
            원하는 코드
        }
        */

        /*이런식으로 사용을 한다*/
        int number1 = 1; // while은 for와 달리 값설정이 따로 없다.
        while(number1 < 11) { // number값이 10이 되는순간 종료
            System.out.println("number1 : " + number1);
            number1++;
        }
        // number의 값이 "11미만"일때 블럭내에 코드가 무한반복한다.

        /*while은 for와 달리 초기값이나 완료값이 없기 때문에 무한반복을 할 수 있다.*/
        /*
        while (true) { // 조건은 그냥 참이다, 그냥 옳다.
            System.out.println("무한반복, 렉조심");
        }
        */
                        /*-----------------------------------------------------*/

        /*그리고 while과 비슷한 do-while이 있다.*/
        /*문법은 while과 비슷하지만 조금 다르다.*/
        /*
        do {

        } while (조건문); <- ";" 세미콜론 붙이는거 꼭 잊으면 안된다
        */

        /*이런식으로 사용을 한다*/
        int number2 = 1; // do-while의 가장 눈에 띄는 차이점은 while의 위치다.
        do {
            System.out.println("number2 : " + number2);
            number2++;
        } while(number2 < 11);

        /*while과 가장 큰 차이점은 do-while은 무조건 한번은 구문이 실행이 된다는 점이다.*/
        /*조금 전문가스럽게 이야기하면 조건문의 실행시간의 차이다.*/
        int number3 = 3;
        while (number3 > 4) {
            System.out.println("while이 실행이 될까요?");
            number3++;
        }

        do {
            System.out.println("do-while이 실행이 될까요?");
            number3++;
        } while (number3 > 4);

        /*같은 조건이지만 다른 결과를 알 수 있고 가장 큰 차이점을 바로 알 수 있다.*/
        /*이렇게 같지만 비슷한 문법을 상황에 맞춰서 잘 사용하면 된다.*/

        /*끝으로 사실 처음배울때는 for와 while을 대체 언제 써야하나 이런 고민을 했다*/
        /*그래서 내린 결론은 반복의 횟수의 유무에 따라서 정하기로 했다.*/
        /*반복횟수가 있다면 for문 없다면 while문 이런식으로 사용을 하면 조금 더 편하게 고를 수 있다.*/
    }

}
