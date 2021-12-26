package level_01.java_chap01;

// 자바와 Switch

public class Chap_9 {

    // 개인적인 생각으로 switch는 정말 특이한? 문법이라고 생각을한다.
    // if와 비슷한 논리문이다.
    public static void main(String[] args) {
        /*사용방법은 아래와 같다.*/
        /*
        switch (조건값) {
            case 값1:
                코드;
                break;
            case 값2:
                코드;
                break;
            default:
                코드;
        }
        */
        /*지금까지 본 문법들과는 정말 다른 모습을 하고 있다.*/

        /*실제로 사용을 하면 이런 모습이다*/
        int number = 3;
        String numberToKorean;
        // 각 case마다 break는 "선택사항"이다, 필수로 꼭 입력해야하는것이 아니다.
        // break가 없다면 다음 case까지 실행이 되므로 잘 선택해서 넣어줘야한다.
        switch (number) { // 사용하고싶은 값을 넣는다.
            case 1: // 1과 3은 다른 값이므로 다음 case로 넘어간다.
                numberToKorean = "1입니다";
                break;
            case 2: // 2와 3도 다르므로 다음 case로 넘어간다.
                numberToKorean = "2입니다";
                break;
            case 3: // 3과 3은 같으므로 case안에 있는 코드가 실행이 된다.
                numberToKorean = "3입니다";
                break;
            default: // 위의 case가 모두 실행되지 않으면 실행이 된다.
                numberToKorean = "1이상 3이하로 해주세요";
        }
        System.out.println(numberToKorean);

        /*조금 더 응용을 하면 이렇게 할 수 있다*/
        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("i는 5보다 작아요");
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.println("i는 10보다 작아요");
                    break;
                default:
                    System.out.println("i는 10보다 크네요?");
            }
        }

        /*switch문은 이 외에도 Enum과 응용을 하는등.. 막상 사용하는 장소를 찾기가 어렵다는 점이 있다.*/
        /*if문과 비슷한 논리조건이지만 switch는 이러한 사용에 제한때문에 특정상황에서 주로 사용하는거 같다.*/
    }
}
