package anno.reflectanno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target 约束该注解只能作用于类接口或枚举上
 * @Retention 表示这是一个运行时注解，可以通过反射技术获取注解中的信息
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String username();
    int age() default 18;
}
