package ynd.core.annotation;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthPermissions {

    String value() default "";

    String description() default "this is a default auth‘s description";
}
