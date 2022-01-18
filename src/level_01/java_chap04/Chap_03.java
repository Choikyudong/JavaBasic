package level_01.java_chap04;

// java.lang 패키지 - 2 (StringBuffer, StringBuilder)
// String 클래스와 같으면서도 다른 클래스들이다.
public class Chap_03 {

    public static void main(String[] args) {
        // 우선 String 클래스는 생성할 때 지정된 문자열을 변경할 수 없다.
        // 하지만 Buffer는 가능하다. 이유는 내부적으로 편집을 위한 Buffer가 있기 때문이다.

        // 우선 StringBuffer는 기본적으로 16문자를 저장할 수 있는 Buffer를 가진다.
        StringBuffer buffer = new StringBuffer(); // 16문자를 담을 수 있는 기본적인 버퍼를 생성

        // 원한다면 개수를 지정할 수 있다.
        StringBuffer buffer1 = new StringBuffer(10); // 10문자를 담을 수 있는 버퍼를 생성

        // 지정된 문자를 가진 StringBuffer를 생성한다.
        StringBuffer buffer2 = new StringBuffer("안녕하세요");

        /*append(All)*/
        // 매개변수로 들어온 값(boolena, int 등등)을 "문자열"로 변환한 뒤 해당 StringBuffer의 문자열에 덧붙인다.
        // 반환타입 : StringBuffer
        StringBuffer example = new StringBuffer("Hello");
        System.out.println(example.append(" World!")); // 글자를 합친다고 생각하자

        /*capacity()*/
        // 해당 StringBuffer의 버퍼크기를 알려준다.
        // 반환타입 : int
        System.out.println(buffer.capacity()); // 기본 크기인 16이 나온다.

        /*charAt(int)*/
        // 지정된 위치(index)에 있는 '문자'를 반환한다.
        // 반환타입 : char
        System.out.println(buffer2.charAt(2)); // '하'를 반환한다.

        /*delete(int, int)*/
        // 시작위치(첫번째 파라미터)부터 끝 위치(두번째 파라미터) "사이에 있는" 문자를 제거한다. 끝 위치의 문자는 포함하지 않는다.
        // 반환타입 : StringBuffer
        StringBuffer buffer3 = new StringBuffer("JavaScript");
        System.out.println(buffer3.delete(4,10));

        /*insert(int, all)*/
        // 지정된 위치(첫번째 파라미터)에 두 번째 매개변수로 받은 값을 "문자열"로 변환하여 추가한다. 위치는 0부터 시작
        // 반환타입 : StringBuffer
        StringBuffer buffer4 = new StringBuffer("안녕세요");
        System.out.println(buffer4.insert(2,"하"));
        System.out.println(buffer4.insert(5, " " + buffer3 + "!"));
        StringBuffer buffer5 = new StringBuffer("오늘 기온은");
        double exampleInsert = 14.6;
        System.out.println(buffer5.insert(6, " " + exampleInsert + "입니다."));

        /*length()*/
        // StringBuffer에 저장되어 있는 "문자열의 길이"를 반환
        // 반환타입 : int
        StringBuffer buffer6 = new StringBuffer(15); // 해당 버퍼의 길이는 15로 설정
        buffer6.append("무슨 내용을 적어야 좋지?"); // 14개의 문자를 입력
        System.out.println(buffer6.length()); // 버퍼의 길이 설정과는 무관하게 "입력된 문자열의 길이"가 나온다.

        /*replace(int, int, String)*/
        // 지정된 위치(int ~ int)의 문자들을 주어진 문자열(String)으로 변경한다. 다만 마지막 위치의 문자는 범위에 포함하지 않는다.
        // 반환타입 : StringBuffer
        System.out.println(buffer6.replace(11, 13, "할까"));

        /*reverse()*/
        // 문자열의 순서를 거꾸로 나열한다.
        // 반환타입 : StringBuffer
        StringBuffer buffer7 = new StringBuffer("987654321");
        System.out.println(buffer7.reverse());
        System.out.println(buffer6.reverse());

        /*setCharAt(int, char)*/
        // 지정된 위치의 문자를 주어진 문자로 바꾼다.
        // 반환타입 : void
        StringBuffer buffer8 = new StringBuffer("Hello");
        buffer8.setCharAt(0, 'C');
        System.out.println(buffer8);

        /*setLength(int)*/
        // 지정된 길이로 "문자열의 길이"를 변경한다. 길이를 늘리는 경우에는 빈 공간을 널문자로 채운다.
        // 반환타입 : void
        StringBuffer buffer9 = new StringBuffer(5);
        buffer9.append("01234");
        System.out.println(buffer9.capacity()); // 버퍼크기는 5
        System.out.println(buffer9.length()); // 문자열의 길이 변화에 주목
        buffer9.setLength(3);
        System.out.println(buffer9.capacity()); // 버퍼크기는 여전히 5
        System.out.println(buffer9.length()); // 문자열의 길이 변화에 주목
        buffer9.setLength(10);
        System.out.println(buffer9.capacity()); // 길이가 늘어나니 조금 달라진다.
        System.out.println(buffer9.length()); // 문자열의 길이 변화에 주목

        /*toString()*/
        // StringBuffer를 String으로 변환한다.
        // 반환타입 : String
        StringBuffer stringBuffer = new StringBuffer("반가워요");
        System.out.println(stringBuffer.getClass());

        String string = stringBuffer.toString();
        System.out.println(string.getClass());

        /*subString(int), subString(int, int)*/
        // 지정된 범위 내의 문자열을 String으로 뽑아서 반환한다. 시작위치만 입력시 시작위치부터 끝까지 반환한다, 마지막은 포함 안함
        // 반환타입 : String
        StringBuffer stringBuffer1 = new StringBuffer("Hello Java!");
        System.out.println(stringBuffer1.substring(6));
        System.out.println(stringBuffer1.substring(2, 4));

        /*StringBuilder*/
        /*StringBuffer와 정말로 유사한 클래스이다, 다만 둘의 큰 차이점은 "멀티쓰레드"이다.*/
        /*멀티쓰레드로 작성된 프로그램이 아니라면 StringBuffer의 동기화는 불필요하게 성능만 떨어뜨리니*/
        /*그럴땐 StringBuilder를 사용하면 된다. */
        StringBuilder stringBuilder = new StringBuilder("안녕하세요");

        /*StringBuffer와 StringBuilder에 대해서 기본적인 메서드만 기록했는데 더 많으니 찾아보자.*/

    }

}
