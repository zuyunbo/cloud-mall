package com.spring.formework.annotations;


import java.lang.annotation.*;


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GRequestMapping {

    String value() default "";

}
