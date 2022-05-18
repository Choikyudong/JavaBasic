package java_forChap.ser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ChildClass extends SuperClass implements Serializable {

    // 직접적으로 직렬화에 추가되는 데이터
    String addVar;

    public ChildClass(String var1, String var2, String addVar) {
        super(var1, var2);
        this.addVar = addVar;
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "addVar='" + addVar + '\'' +
                ", var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                '}';
    }

    /**
     * 직렬화를 수행할 때 직렬화를 직접적으로 구현하지 않는
     * 데이터들은 이런식으로 정해진 규칙에 따라야만 직렬화가 가능하다.
     * 
     * 여기서 private 설정과 이름들은 규칙이라고 한다. 사실 상 밑에처럼 하는게 규칙인듯
     *
     * 끝에 default...Object()는 커스텀 직렬화 후 마지막에 실행을 해야한다고 한다.
     * 정확하게는 ChildClass에 존재하는 addVar를 직렬화 하는 과정이라고 한다.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        // 이런식으로 슈퍼클래스에 있던 값들을 넣어준다.
        objectOutputStream.writeUTF(var1);
        objectOutputStream.writeUTF(var2);
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        var1 = objectInputStream.readUTF();
        var2 = objectInputStream.readUTF();
        objectInputStream.defaultReadObject();;
    }

}
