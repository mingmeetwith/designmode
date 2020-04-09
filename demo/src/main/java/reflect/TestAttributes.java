package reflect;

import java.lang.reflect.Field;

public class TestAttributes {
    public static void main(String[] args) {
        Class stu = null;
        try {
            stu = Class.forName("reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取对象的所有公有属性。
        Field[] fields = stu.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("---------------------");
        // 获取对象所有属性，但不包含继承的。
        Field[] declaredFields = stu.getDeclaredFields();
        for (Field ff : declaredFields) {
            System.out.println(ff);
        }

    }

}
