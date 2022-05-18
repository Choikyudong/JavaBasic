package java_forChap.reflection.obj2;

public class Cat {

    private String name;
    private int age;
    private boolean sex;
    private final String settingSex;

    public Cat(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        if (sex) {
            this.settingSex = "수컷";
        } else {
            this.settingSex = "암컷";
        }
    }

    public void meow() {
        System.out.println("냐용");
    }

    public void punch() {
        System.out.println("냥냥");
    }

    private void eat() {
        System.out.println("뇸뇸뇸");
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

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + settingSex +
                '}';
    }

}
