package ynd.core.annotation;

import ynd.core.emums.DesensitizationRulesEnum;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface FieldDesensitized {

    /*脱敏类型(规则)*/
    DesensitizationRulesEnum type();

    /*判断注解是否生效的方法*/
    String isEffectivelyMethod() default "";

}