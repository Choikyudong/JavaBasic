package java_forChap.ser;

import java.io.Serializable;

public class DataObject implements Serializable {

    String name;
    String password;
    transient String secret;

    public DataObject(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public DataObject(String name, String password, String secret) {
        this.name = name;
        this.password = password;
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }

}
