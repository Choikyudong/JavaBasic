package level_01.java_chap00;

// 자바와 정규식
// 정규식이란 텍스트 데이터 중에서 원하는 조건(패턴)과 일치하는 "문자열"을 찾아 내기 위해서 사용한다.
// 요즘에는 다양한 언어에서 정규식을 지원하고 있어서 원하는 데이터를 잘 확인할 수 있다.

// 해당 패키지를 통해서 자바에서 제공하는 정규식을 손쉽게 사용할 수 있다.
import java.util.regex.*;

public class Chap_02 {

    public static void main(String[] args) {
        String[] data = {"caoo", "baby", "fire", "gun", "apple", "castle", "car", "body", "water", "phone", "Cow"};

        // Pattern 클래스에서 static으로 제공하는 complie 메서드를 통해서 정규식을 정의할 수 있다.

        // 해당 정규식은 c로 시작하는 소문자 영단어를 찾아낸다. *를 붙여서 마무리하면 글자수 제한이 없이 찾는다.
        Pattern pattern = Pattern.compile("c[a-z]*");

        for (String arr : data) {
            Matcher matcher = pattern.matcher(arr); // Matcher클래스로 Pattern을 확인한다.
            if (matcher.matches()) { // 해당 메서드로 정규식에 해당하는 확인한다.
                System.out.print(arr + ", ");
            }
        }

        // 위에까지가 가장 간단하게 정규식 클래스로 만들어본 예시이다.
        // 이제는 Pattern 클래스로 어떠한 패턴이 가능한지 부터 알아보자.
        /*
            밑에 예시는 많은 사람들이 사용하는 정규식패턴일뿐 꼭 이렇게 해야한다는 것은 절대로 아니다.
            
            1. a[a-z]* : a로 시작하는 영단어 -> a, abc, apple ...
            2. a[a-z] : a로 시작하는 두 자리 영단어 -> ab, ao, ap ...
            3. a[a-zA-Z] : a로 시작하는 두 자리 영단어 대소문자 구분안함 -> Aa, AA, Ab, ab ...
            4. a[a-zA-Z0-9] : a로 시작하고 숫자와 영어로 조합된 두 글자 -> a0, a1, aA ...
            5. .* : 모든 문자열 -> abc, cat, castle ....
            6. a. : a로 시작하는 두 자리 문자열 -> ab, aa, aA, a0, a# ...
            7. a.* : a로 시작하는 모든 문자열 -> aled, samsung, lg, apple
            8. a.*b : a로 시작하고 b로 끝나는 모든 문자열 -> asssb, aqwrb, aeddcb ....
            9. [a|c].* : a 또는 c로 시작하는 문자열 -> cat, apple, cow, app ...
            10. [^a|c].* : a 또는 c로 시작하지 않는 문자열 -> bad, quiz, no ...
         */

        /*정말 간단한 예제들만 가져왔는데도 엄청 많다.. 정규식이 제대로 공부하면 생각보다 범위도 넓고*/
        /*복잡하기도 하지만 위의 예제부터 시작해서 조금씩 배우면 충분히 해낼 수 있다.*/
        /*깊게 공부하는 것도 좋지만 초급단계일때에는 기초적인 부분만 기억하고 넘어가는 것이 조금 더 좋다고 생각한다.*/

    }

}
