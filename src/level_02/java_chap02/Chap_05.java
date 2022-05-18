package level_02.java_chap02;

// Enum(열거형)

// 내부적으로 사용가능한 열거형 상수의 값을 사용할 수 있다.
enum AddEnumMember {

    // 기존 열거형과 다르게 ';'를 꼭 붙어야한다.
    MEMBER1(1000);

    // 정수를 저장할 필드
    private final int number;

    // 생성자를 추가해야 한다. 또한 열거형의 생성자는 'private'이다.
    AddEnumMember(int number) {
        this.number = number;
    }

    // 일반적인 클래스 사용하듯이 할 수 있다.
    public int getNumber() {
        return number;
    }

}

// 사용하다보면 일반적인 클래스 생성하는거와 크게 다른점을 느끼지 못할 수 있다.
enum TestMembers {

    // 원한다면 여러개의 열거형 상수를 입력해도 된다.
    MEMBERS1("1등급",100.0d, 'a'), MEMBERS2("2등급",95.5d, 'b'),
    MEMBERS3();

    // 꼭 final을 붙이거나 private를 꼭 붙어야 하는것은 아니다.
    String grade;
    double result;
    char rank;

    TestMembers() {
        this("이 친구는 등급이 뭔가요?");
    }

    TestMembers(String grade) {
        this.grade = grade;
    }

    TestMembers(String grade, double result, char rank) {
        this.grade = grade;
        this.result = result;
        this.rank = rank;
    }

}

public class Chap_05 {

    public static void main(String[] args) {

        // 사용도 일반적으로 클래스 사용하듯이 하면 된다.
        TestMembers testMembers = TestMembers.MEMBERS3;
        System.out.println(testMembers.grade);

        AddEnumMember addEnumMember = AddEnumMember.MEMBER1;
        System.out.println(addEnumMember.getNumber());
    }

    // 그렇다면 어떻게 Enum이 이렇게 가능한지에 대해서 알아보면서 마무리한다.
    // 예를들어 이런 Enum이 있다고 가정을 한다.
    enum Example_1 {
        A, B, C, D
    }

}

// 조금 더 익숙한 클래스형태로 위의 Enum을 변경하면 이렇게 된다고 한다.
class Example_2 { // 이름도 Example_1이랑 같다고 생각을 하자

    static final Example_2 A = new Example_2("A");
    static final Example_2 B = new Example_2("B");
    static final Example_2 C = new Example_2("C");
    static final Example_2 D = new Example_2("D");

    private String name;

    private Example_2(String name) {
        this.name = name;
    }

}

// 이 형태와 비슷하다고 한다. 이렇게 생각을 해보면 클래스처럼 사용이 가능한 이유를 조금은 어색하지 않을 것 이다.
// '=='으로 비교가 가능한 이유도 같은 객체의 주소이며, 값이 바뀌지 않기에 가능한 것이다.