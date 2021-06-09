package com.spring.formework.annotations;


import java.lang.annotation.*;


@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GRequestParam {

    String value() default "";

}
