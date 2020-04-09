package anno.reflectanno;

public class MainDriver {

    public static void main(String[] args) {
        // 通过反射获得Person类的class对象
        Class<Person> clazz = Person.class;
        if (clazz.isAnnotationPresent(MyAnno.class)) {
            // 通过class对象获取MyAnno注解对象
            MyAnno anno = clazz.getAnnotation(MyAnno.class);
            // 获取注解中的属性值
            String username = anno.username();
            int age = anno.age();
            System.out.println(username + " " + age);
        } else {
            System.out.println("该类上没有注解！");
        }
    }
}
