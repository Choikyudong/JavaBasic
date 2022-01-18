package level_01.java_chap00;

/*예외처리(Exception Handling)*/
public class Chap_01 {

    /*프로그램 실행시 다양한 원인에 의해서 오작동 또는 작동 중지가 발생하는데*/
    /*이런 결과를 초래하는 원인을 프로그램 에러 또는 오류라고 한다.*/

    /*또한 에러의 "발생시점"에 따라서 "컴파일 에러", "런타임 에러"로 나눌 수 있다.*/
    /*컴파일 에러 : 컴파일 시에 발생하는 에러*/
    /*런타임 에러 : 실행 시에 발생하는 에러*/

    /*자바에서는 실행 시 발생하는 프로그램 에러(오류)를 에러, 예외 두 가지로 구분한다.*/
    /*에러 : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류*/
    /*에외 : 프로그램 코드에 의해서 수습될 수 있는 미약한 오류*/

    // 본격적으로 예외처리를 해보자
    public static void main(String[] args) {
        /*예외처리 문법*/
        try { // 예외 발생 가능성이 높은 코드를 넣는다.
            System.out.println(0 / 0);
        } catch (Exception e) { // 예상가능한 예외 종류를 넣는다.
            System.out.println("Exception은 자바의 모든 예외를 담당하는 부모클래스이다.");
        }

        /*위의 코드는 try문으로 시작해서 try문에서 예외가 발생되면*/
        /*catch문에서 미리 정해놨던 문장이 실행된다.*/
        /*만약 try문에서 이상이 없다면 catch문을 무시하고 진행한다.*/


        /*그렇다면 이제 예외설정을 조금 더 보자*/

        int[] array = {1,2,3,4,5}; // 길이 5를 가진 배열이 있다
        int sum = 0; // 그리고 배열의 값들을 모두 더 하는 알고리즘이다.
        try {
            // 가끔 배열길이를 잘못설정해서 오류가 발생할때가있다.
            for (int i = 0; i < 7; i++) {
                sum += array[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // 이때 예상가능한 예외를 넣어두자. (해당 예외는 배열길이가 초과시 발생하는 예외이다)
            System.out.println("배열길이가 넘었어요");
        } catch (Exception e) {
            System.out.println("catch문은 이렇게 연속적으로 사용가능하다.");
        }

        /*catch는 가장 상황에 맞는 예외에 멈추면 해당 문장을 실행하고 종료한다.*/
        try {
            int result = 0/0;
        } catch (IllegalArgumentException e) {
            System.out.println("여기서 멈추나? : 1");
        } catch (ArithmeticException e) {
            System.out.println("여기서 멈추나? : 2");
        }
        /*위의 예시에서는 ArithmeticException이 가장 잘 맞는 상황이기 때문에 해당 문장을 실행한다.*/

        /*멀티 catch 블럭*/
        try {

        } catch (ArrayIndexOutOfBoundsException | StackOverflowError e) {
            System.out.println("이렇게 하나의 catch블럭으로 만들수있다. 여기서 |는 단순하게 구분하는 용도이다.");
        }

        /*finally 키워드로 try문 실행 후 "무조건" 실행해야하는 문장을 적을 수 있다.*/
        try {
            int result = 0/0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("해당 catch문은 무시");
        } catch (ArithmeticException e) {
            // 예외발생 시 호출스택에 있던 메소드 정보와 예외 메시지를 화면에 출력
            e.printStackTrace();

            // 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻는다.
            System.out.println(e.getMessage());
        } finally {
            System.out.println("안녕하세요");
        }

        /*그리고 예외를 당하는것만 아니라 일부러 발생시킬 수 있다.*/
        /*바로 throw 키워드에 예외를 넘기면 된다.*/
        try {
            Exception e = new Exception("예외 발생!");
            throw e;
            // throw new Exception("예외 발생!)" -> 한줄로도 가능하다.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // 더 나아가서 메서드에도 예외를 선언할 수 있다.
    // 이때 throws 키워드를 이용하면 된다.
    void method() throws Exception {
        // 참고로 오버라이딩시 해당 예외설정도 모두 가져가니 주의해야함
    }

    // 마지막으로는 자신이 새로운 예외를 만들 수 있다.
    class MyException extends Exception {
        MyException(String msg) {
            super(msg);
        }
    }

    // 위에 적힌 예외 설명들은 정말 줄이고 줄인 부분들이다.
    // 해당 부분이 익숙해졌다면 좀 더 다른 부분을 살펴보면 좋은 프로그램을 만들 수 있을것이다.
}
