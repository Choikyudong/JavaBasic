package level_01.java_chap04;

import java.util.Arrays;

// java.lang 패키지 - 2 (String)
// 문자열을 사용할 때 사용하는 "클래스"인 String이 맞다.
public class Chap_02 {

    public static void main(String[] args) {
        // String을 사용하는 방법은 대표적으로 2가지가 있다.
        String str1 = "안녕하세요";
        String str2 = new String("안녕하세요"); // 생성자를 이용

        // str2는 생성자를 이용하기 때문에 항상 새로운 인스턴스가 만들어진다.
        // 반면에 str1은 문자열으로 한다면 이미 존재하는 것을 재사용한다.

        /*String은 많이 사용하는 클래스이며 안에 있는 메서드도 많이 사용되니 알아두면 좋다.*/

        // 우선 String은 문자배열을 String 타입으로 생성이 가능하다.
        char[] ex1 = {'안', '녕', '하', '세', '요'};
        String str3 = new String(ex1);

        // String 구조 관련해서 앞으로 위치에 있는 글자를 가져오는 메서드가 있는데
        // 배열에서 지정된 위치의 글자를 가져온다고 생각하면 이해가 바로 될 것이다.

        /*chartAt(int)*/
        // 지정된 위치(index)에 있는 "문자"를 알려준다. 
        // 반환타입 : char
        System.out.println(str3.charAt(1)); // 출력은 '녕' 이다.

        /*설명에 index라고 표현을 하는 이유는 문자열의 구성이 ex1처럼 되어있기 때문이다.*/
        /*조금 더 쉽게 말을하면 char 배열을 하나로 묶어서 사용을 하는것이 String이다.*/

        /*compareTo(String)*/
        // 문자열을 비교하는데 "사전순"으로 비교를 한다, 같으면 0, 이전이면 음수, 이후면 양수
        // 반환타입 : int
        System.out.println("abc".compareTo("abc")); // -> 0
        System.out.println("a".compareTo("b")); // -> -1
        System.out.println("b".compareTo("a")); // -> 1

        /*concat(String)*/
        // 문자열 뒤에 문자열을 추가한다.
        // 반환타입 : String
        String str4 = "Hello";
        System.out.println(str4.concat(" World!!!")); // concat안의 내용들을 기존 String에 합친다.

        /*contains(CharSequence)*/
        // CharSequence는 String에 구현이 되어있는 인터페이스로 마크업문자에 대한 변형이 가능한 문자, 연속된 문자이다.
        // 지정된 "문자열"이 포함되어있는지 검사한다.
        // 반환타입 : boolean
        System.out.println("Hello".contains("el")); // 포함하므로 true
        System.out.println("World".contains("he")); // 없으므로 false
        System.out.println("dell".contains("dl")); // 없으므로 false
        System.out.println("Apple".contains("a")); // 대소문자를 구별하므로 false

        /*startsWith(String)*/
        // 지정된 문자열로 시작하는지 검사한다.
        // 반환타입 : boolean
        System.out.println("안녕하세요!".startsWith("안")); // 첫번째가 같으므로 true
        System.out.println("Java".startsWith("J")); // 첫번째가 같으므로 true
        System.out.println("World!".startsWith("w")); // 대소문자를 구별하므로 false

        /*endsWith(String)*/
        // 지정된 문자열로 끝나는지 검사한다.
        // 반화타입 : boolean
        System.out.println("안녕하세요!".endsWith("세요")); // 끝이 다르므로 false
        System.out.println("Java".endsWith("a")); // 끝이 같으므로 true
        System.out.println("World!".endsWith("rld!")); // 끝이 같으므로 true

        /*equals(Object)*/
        // Object의 equlas를 String클래스에서 오버라이딩한 메서드이다, "문자열"이 같은지 비교한다.
        // 반화타입 : boolean
        String str5 = "Hello World!";
        System.out.println("Hello World!".equals(str5)); // 같은 문자열이므로 true
        System.out.println("HelloWorld!".equals(str5)); // 다른 문자열이므로 false
        // 공백도 엄연한 '문자'이기 때문에 위의 예시는 다른 "문자열"이다.
        System.out.println("hello World".equals(str5)); // 다른 문자열이므로 false
        // 자바에서는 "대소문자"를 구별하기 때문에 둘은 전혀 다른 "문자열"이다.

        /*equalsIgnoreCase(String)*/
        // 위의 String.equals와 같이 "문자열"이 같은지 확인하는 메서드이나 차이점은 [대소문자 구분없이 비교한다]
        // 반환타입 : boolean
        System.out.println("hello world!".equalsIgnoreCase(str5)); // 대소문자가 달라도 같은 '문자'이니 true

        /*indexOf(int), indexOf(int, int), indexOf(String) <- 오버로딩이 되어있는 메서드이다.*/
        // 주어진 '문자'가 문자열에 존재한다면 해당하는 위치(index)를 알려준다. 없다면 -1
        // 반환타입 : int
        System.out.println("안녕하세요!".indexOf('안')); // 문자 '안'이 있는 위치인 0을 반환
        System.out.println("하이하이!".indexOf("하", 1)); // 지정된 위치 1인덱스 이후부터 찾는다.

        /*lastIndexOf(int), lastIndexOf(String)*/
        // 문자열의 "오른쪽 끝"에서부터 지정된 문자를 찾는다.
        // 반환타입 : int
        System.out.println("안녕하세요!".lastIndexOf('세')); // 글자의 위치를 알려준다.
        System.out.println("I like coffee and hate coding".lastIndexOf('d')); // d의 위치(index)인 25가 나온다.

        /*length()*/
        // 문자열의 길이를 알려준다.
        // 반환타입 : int
        System.out.println("I like coffee and hate coding".length()); // 총 "문자열"길이를 알려준다.

        /*replace(char, char), replace(CharSequence, CharSequence)*/
        // 첫번째 파라미터를 두번째 파라미터로 변경한다.
        // 반환타입 : String
        System.out.println("Hello!".replace('!', '~')); // Hello~ 가 출력이 된다.
        System.out.println("Hello World!".replace("World", "Java")); // Hello Java!

        /*replaceAll(regex, String)*/
        // "정규식" 또는 "지정된 문자열"과 일치하는 "문자열"을 두번째 파라미터의 값으로 "모두" 바뀐다.
        // 반환타입 : String
        System.out.println("AABBCCAABBCC".replace("AA", "DD"));
        System.out.println("AABBCCAABBCC".replaceAll("AA", "DD"));
        // 위의 결과값은 같다. 이것만 보면 2개의 차이점이 없다. 하지만 All의 참맛은 "정규식"을 사용해야 한다.
        System.out.println("AABBCCAABBCC".replaceAll("[A-C]", "DD")); // [] <- 정규식

        /*replaceFirst(regex,String), replaceFirst(regex)*/
        // "정규식" 또는 "지정된 문자열"과 일치하는 것중에서 첫번째에 해당하는 부분만 변경한다.
        // 반환타입 : String
        System.out.println("AAAAAA".replaceFirst("A", "QQ"));
        System.out.println("ABCDEABCDE".replaceFirst("[A-C]", "X"));

        /*split(regex), split(regex, int)*/
        // 문자열을 "지정된 문자열" 또는 "정규식"으로 나누어 "배열"에 담는다.
        // 반환타입 : String[]
        String[] strArr1 = "피카츄,라이츄,파이리,꼬북이".split(",");
        System.out.println(Arrays.toString(strArr1)); // Arrays 클래스는 배열과 관련된 여러 메서드들이 들어있는 클래스이다.
        String[] strArr2 = "피카츄,라이츄,파이리,꼬북이".split(",", 2); // 2번째 "문자열" 부터 잘라서 넣는다.
        System.out.println(strArr2[0]);
        System.out.println(strArr2[1]);

        /*substring(int), substring(int, int)*/
        // 주어진 시작값부터 끝 위치까지 "지정된 문자열"을 얻는다. 다만 시작 위치의 값은 얻나 "끝 위치의 값은 포함하지 않는다".
        // 반환타입 : String
        System.out.println("피카츄,라이츄,파이리,꼬북이".substring(4)); // 끝 위치까지 지정을 하지 않음
        System.out.println("피카츄,라이츄,파이리,꼬북이".substring(4, 7)); // 끝 위치를 지정함

        /*toLowerCase()*/
        // 해당 문자열을 모두 "소문자"로 변환한다.
        // 반환타입 : String
        System.out.println("HELLO WORLD!".toLowerCase());

        /*toUpperCase()*/
        // 해당 문자열을 모두 "대문자"로 변환한다.
        // 반환타입 : String
        System.out.println("hello world!".toUpperCase());

        /*trim()*/
        // 문자열의 "왼쪽" 그리고 "오른쪽" 공백을 제거한다. 다만 중간중간에 있는 공백은 제거되지 않는다.
        // 반환타입 : String
        System.out.println("     Hello World!       ".trim());
        System.out.println("Hello                  World!".trim());

        /*valueOf(All)*/
        // 지정된 값을 "문자열"로 변환한다. 여기서 All로 적은 이유는 너무 많아서 이렇게 했다...
        // 반환타입 : String
        String trueToString = String.valueOf(true);
        System.out.println(trueToString); // 이러면 boolean 값인 true가 "문자열"이 된다.
        String intToString = String.valueOf(1351351351);
        System.out.println(intToString); // 마찬가지로 int 값이 "문자열"이 된다.

        /*String.join(regex, all)*/
        // 여러 문자열 사이에 구분자를 넣어서 결합한다.
        // 반환타입 : String
        System.out.println(String.join("-", strArr1)); // split과 반대라고 생각하면 편하다.

        /*String.format()*/
        // printf와 사용법이 완전히 똑같다.
        // 반환타입 : String
        System.out.println(String.format("%s는 바보입니다.", "짱구"));
        System.out.printf("%s는 바보입니다.", "짱구");

        /*가장 자주 사용된다고 생각하는 String의 메서드만 살펴보는데도 엄청 많다. 이 외에도 다른 메서드들도 찾아보자.*/
    }

}
