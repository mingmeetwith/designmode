package generics;

import reflect.Person;
import reflect.Study;

public class Student{
    public String className;// 班级
    private String address;// 住址

    public Student() {
        super();
    }

    public Student(String name, int age, String className, String address) {
        this.className = className;
        this.address = address;
    }

    public Student(String className) {
        this.className = className;
    }

    public String toString() {
        return "班级：" + className + ",住址："
                + address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}