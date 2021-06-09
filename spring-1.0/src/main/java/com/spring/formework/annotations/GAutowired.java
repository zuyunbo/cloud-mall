package com.spring.formework.annotations;


import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GAutowired {

    String value() default "";

}
