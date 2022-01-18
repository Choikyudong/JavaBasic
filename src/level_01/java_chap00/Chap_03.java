package level_01.java_chap00;

import java.util.StringTokenizer;

/*StringTokenizer클래스*/
/*StringTokenizer는 지정된 구분자(delimiter)를 기준으로 토큰이라는 여러 개의 "문자열"을 잘라내는 데 사용된다.*/
/*비슷한 기능을 하는 예로는 String클래스의 split이 있다.*/
public class Chap_03 {

    public static void main(String[] args) {
        String example1 = "100,200,300,400";

        // 파라미터의 첫번째에는 원하는 문자열 그리고 두번째에는 구분자를 넣는다.
        StringTokenizer tokenizer = new StringTokenizer(example1, ",");
        
        // hasMoreTokens()는 토큰이 남아있는지 알려주는 "boolean"타입의 메서드이다.
        while (tokenizer.hasMoreTokens()) { // 토큰이 남아있는 동안 while을 진행
            // nextToken을 이용해서 토큰을 "String"타입으로 반환한다.
            System.out.println(tokenizer.nextToken());
        }

        System.out.println("\n-------------------------------------------\n");

        // 토크나이저에서 구분자열에는 단 "한 문자의 구분자"만 사용이 가능하다.
        String example2 = "x=100*(200+300)/2";

        // 보기에는 +-*/=()가 하나의 구분자인거 같지만 실제는 따로따로 구분자로 들어간다.
        // 세번째 파라미터에는 boolean값을 넣을 수 있으며 true일 경우 "구분자도 토큰"으로 간주된다.
        StringTokenizer tokenizer1 = new StringTokenizer(example2, "+-*/=()", true);

        // countTokens()는 전체 토큰의 수를 int타입으로 반환한다.
        System.out.println("전체 토큰의 수 : " + tokenizer1.countTokens());

        while (tokenizer1.hasMoreTokens()) {
            System.out.println(tokenizer1.nextToken());
        }

        // 토큰은 한 번 사용한 뒤 모두 소모된다.
        System.out.println("전체 토큰의 수 : " + tokenizer1.countTokens());

        System.out.println("\n-------------------------------------------\n");

        // 비슷한 예시 중에서 String클래스이 split()이 있다고 했는데 비교를 해보자.

        String example3 = "100,,,200,300";

        //split은 반환타입이 배열이므로 배열을 받아줘야 한다.
        String[] split = example3.split(",");
        StringTokenizer tokenizer2 = new StringTokenizer(example3, ",");

        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i] + "|");
        }

        System.out.println("개수 : " + split.length);

        int i = 0;
        for (; tokenizer2.hasMoreTokens(); i++) {
            System.out.print(tokenizer2.nextToken() + "|");
        }

        System.out.println("개수 : " + i);

        /*결과를 보면 split은 빈문자열도 토큰으로 인식하여 처리를 하지만*/
        /*토크나이저는 빈 문자열을 토큰으로 인식하지 않는다는 것이 가장 큰 차이점이다.*/

        /*또한 성능에서도 split은 배열로 처리를 하기 때문에 조금 더 느리다고 하지만 크게 신경은 안써도 될듯하다.*/
    }

}
