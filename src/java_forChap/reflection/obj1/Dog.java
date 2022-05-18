package java_forChap.reflection.obj1;
/**
 * 자바 리플레션 테스트용 객체입니다.<br/>
 * 아주 기본적인 형태로 이루어져 있다.
 */
public class Dog extends Animal {

    private String name;
    private int age;
    
    // 실험용 필드
    public char notUseField1;
    public boolean notUseField2;
    double notUseFiled3;
    protected Animal notUseFiled4;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 기본값은 뭘 줘도 상관은 없다.
    public Dog() {
        this("착한강아쥐", 3);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void privateMethod() {
        System.out.println("private method");
    }

    static String staticMethod(boolean b) {
        return "not using this method";
    }

    final void defaultMethod(Object obj) {
        // 콘솔 출력을 위한 메서드
    }
    
    protected void protectedMehotd(Animal animal) {
        // 콘솔 출력을 위한 메서드
    }
    
}
