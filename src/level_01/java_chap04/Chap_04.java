package level_01.java_chap04;

// java.lang 패키지 - 3 (Math)
// 말그대로 수학게산에 유용한 메서드들로 구성되어 있다.
// 해당 클래스는 생성자가 private여서 인스턴스는 생성이 불가능하다.
// 왜냐면 인스턴스변수가 하나도 없기 때문에 생성할 필요가 없어서이다. 해당 클래스의 메서드는 모두 "static"이다.
public class Chap_04 {

    public static void main(String[] args) {
        // 또한 Math클래스는 OS에 의존적인 계산을 한다고 한다.
        // 그래서 각 컴퓨터마다 조금씩의 차이가 발생할 수 있다고 한다.

        /*abs(int), abs(long), abs(float), abs(double)*/
        // 주어진 값의 절대값을 반환한다.
        // 반환타입 : 주어진 숫자타입에 맞춰서 반환
        System.out.println(Math.abs(-10));
        System.out.println(Math.abs(-1634.3324d));

        /*ceil(double)*/
        // 주어진 값을 "올림"하여 반환한다.
        // 반환타입 : double
        System.out.println(Math.ceil(16.33d));
        System.out.println(Math.ceil(0.6544523151351321d));
        System.out.println(Math.ceil(0.15d));

        /*floor(double)*/
        // 주어진 값을 "버리고" 반환한다.
        // 반환타입 : double
        System.out.println(Math.floor(5.98989728972398d));
        double d = (double) 16.234324f;
        System.out.println(Math.floor(d));

        /*max(double, double), max(float, float), max(long, long), max(int, int)*/
        // 주어진 두 값을 비교하여 "큰 값"을 반환한다.
        // 반환타입 : 주어진 숫자타입에 맞춰서 반환
        System.out.println(Math.max(16, 12));
        System.out.println(Math.max(0.153d, 0.1325d));

        /*min(double, double), min(float, float), min(long, long), min(int, int)*/
        // 주어진 두 값을 비교하여 "작은 값"을 반환한다.
        // 반환타입 : 주어진 숫자타입에 맞춰서 반환
        int min = Math.min(13543, 22342);
        System.out.println(min);
        System.out.println(Math.min(31.43534f, 23.34511f));

        /*random()*/
        // 0.0 ~ 1.0범위의 임의의 double값을 반환한다. 1.0은 범위에 포함하지 않는다.
        // 반환타입 : double
        System.out.println(Math.random());
        int random = (int)(Math.random() * 100);
        System.out.println(random);

        /*rint(double)*/
        // 주어진 double값과 가장 가까운 정수값을 double형으로 반환한다.
        // 반환타입 : double
        System.out.println(Math.rint(1.5));
        System.out.println(Math.rint(-5.7));
        System.out.println(Math.rint(7.5));
        System.out.println(Math.rint(-2.2));

        /*rounde(double), round(float)*/
        // 소수점 첫째자리에서 반올림한 정수값(long)을 반환한다.
        // 반환타입 : long
        System.out.println(Math.round(1.5));
        System.out.println(Math.round(-5.7));
        System.out.println(Math.round(7.5));
        System.out.println(Math.round(-2.2));

        /*pow(double, double)*/
        // 전달받은 두개의 파라미터로 제곱연산을 수행한다.
        // 반환타입 : double
        System.out.println(Math.pow(5, 2)); // 5 * 5와 같다.
        System.out.println(Math.pow(7, 3)); // 7 * 7 * 7과 같다.
        System.out.println(Math.pow(4, 10));

        /*sqrt(double)*/
        // 전달받은 파라미터의 제곱근 값을 반환한다.
        // 반환타입 : double
        System.out.println(Math.sqrt(25)); // 25의 제곱값은 5이다.
        System.out.println(Math.sqrt(49));
        System.out.println(Math.sqrt(25234));

        // 가장 많이들 언급되고 사용하는 Math 메서드들을 정리를 했는데
        // 그 외에 다른 메서드들을 잘 사용할려면 수학적인 지식이 필요한거 같아서 여기까지 파악을 했다.


        // 여기까지가 개인적으로 생각했을 때 기초부분이라고 생각한다.
        // 다음 단계에서 부터는 심화부분이며 심화부분까지 익혔을 때
        // 비로소 초급 자바 개발자 단계가 아닐까라고 생각한다.
    }

}
