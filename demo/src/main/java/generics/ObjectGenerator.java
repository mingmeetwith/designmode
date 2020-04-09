package generics;

public class ObjectGenerator implements Generator<Student> {
    @Override
    public Student text() {
        Student student = new Student();
        student.setAddress("青州市");
        return student;
    }

    public static void main(String[] args){
        ObjectGenerator age = new ObjectGenerator();
        System.out.println(age.text().toString());
    }
}
