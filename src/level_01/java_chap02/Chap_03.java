package level_01.java_chap02;

// String과 배열

public class Chap_03 {

    // 사실 String은 Wrapper객체일 때 언급이 좋다고 생각했는데
    // String의 구조를 생각하면 배열파트에도 어울린다고 생각한다.
    public static void main(String[] args) {
        /*우선 String이라는것이 무엇인지 어디에 사용이 되는지 알아야한다.*/
        /*String 사용방법*/
        // String 스트링주소  =  new String("문자열");
           String   str1    =   new String("안녕하세요");

        System.out.println(str1); // "문자열"을 만들어냈다
           
        /*String과 비슷한 기능을 하는게 있는 "기본형 타입"을 생각해보면 char가 있을 것이다.*/
        /*두개 다 "문자"를 다루는 기능이지만 char는 "문자" 그리고 String은 "문자열"이라는 것에 주목해야한다*/
        /*처음부터 char를 "문자"라고 강조를 했던 이유가 String의 존재 때문이였다.*/
        
        /*자바에는 기본적으로 "기본형 타입"과 8개뿐이며 그외에는 전부 기본형 타입이 아니다*/
        /*즉 String은 기본형 타입이 아닌 "객체"형이다.*/
        /*그리고 기본형 타입은 생성할 때 "변수명"이라고 말을 했지만 객체들은 앞으로 "주소"라고 명명할것이다.*/
        /*왜 주소라고 말을 하냐면 해당 str1은 실제로 "안녕하세요"라는 값을 가지는 것이 아니라*/
        /*"안녕하세요"라는 값을 가진 부분의 주소값을 가르키는 역할이기 때문이다.*/
        /*쉽게 생각하면 str1은 "안녕하세요"라는 값을 실제로 들고있지 않고 위치만 알고 값을 빌려온다고 생각하자*/

        // 또한 이렇게 쉽게 생성할 수 있다.
        String str2 = "안녕하십니까"; // 보통은 이렇게 많이 사용한다.

        // 그리고 선언만 할 수 있다.
        String str3;

        str3 = "a"; // 이렇게 글자 하나만 넣어도 상관은 없다. 다만 이렇게 입력되면 "문자열"로써 들어간 것이다.

        /*그렇다면 이제 왜 String이란 객체가 배열파트에 나왔는지 알아보자*/

        /*가장 간단하게 char배열을 String으로 바꿔보자*/
        char[] charToString = {'안', '녕', '하', '세', '요'};
        String getCharMakeString = new String(charToString);
        System.out.println(getCharMakeString);

        /*위의 결과를 토대로 간단하게 생각해보면 char타입의 배열을 기반으로 String이 만들어졌다는것을 알 수 있다.*/

        /*반대로도 해보자*/
        String str4 = "char타입으로 돌려보자";
        char[] stringToChar = str4.toCharArray(); // String "객체의 메서드"를 사용하자
        for (char c : stringToChar) {
            System.out.print(c);
        }

        /*결과는 예상한대로 아무런 문제없이 변환이 잘 된다.*/

        /*그리고 변환할 때 toCharArray()라는 "메서드"를 사용했는데 여기서 또 하나를 확실하게 알 수 있다.*/
        /*String은 객체라는 사실이다. 기본형타입은 객체가 아니기 때문에 자체적으로 메서드가 존재하지 않는데*/
        /*String은 객체이기 때문에 이렇게 기본적으로 메서드가 존재한다.*/

        /*String에는 다양한 메서드들이 존재하고 실제로 코드를 작성하다보면 String클래스를 많이 사용한다.*/
        /*진짜로 많이 사용한다. 아마 가장많이 사용하는 객체이지 않을까 싶다. 그래서 빨리 익숙해지면 좋다.*/

    }

}
