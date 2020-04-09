package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestReflect {
    @SuppressWarnings("unchecked")
    public static void main(String[] args)  {
        try {
            //获取class对象
            Class c = Class.forName("reflect.Student");
            Student stu1 = (Student) c.newInstance();

            // 第一种方法，实例化默认构造方法，调用set赋值
            stu1.setAddress("深圳南山");
            System.out.println(stu1);

            // 第二种方法 取得全部的构造函数 使用构造函数赋值
            Constructor<Student> constructor = c.getConstructor(String.class,
                    int.class, String.class, String.class);
            Student stu2 = (Student) constructor.newInstance("李四", 18, "七班", "深圳");
            System.out.println(stu2);

            /**
             * 獲取方法并执行方法
             */
            Method show = c.getMethod("showInfo");//获取showInfo()方法
            Object object = show.invoke(stu2);//调用showInfo()方法

            System.out.println(object);

            //①通过类装载器获取Car类对象
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class clazz = loader.loadClass("reflect.Student");

            //②获取类的默认构造器对象并通过它实例化Car
            Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
            Student car = (Student) cons.newInstance();

            //③通过反射方法设置属性
            Method setBrand = clazz.getMethod("setAddress", String.class);
            setBrand.invoke(car, "红旗CA72");
            System.out.println(car);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
