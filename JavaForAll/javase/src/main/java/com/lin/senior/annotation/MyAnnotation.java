package com.lin.senior.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({FIELD, TYPE, PARAMETER, METHOD})
@Inherited
public @interface MyAnnotation {

    String value() default "linsz";
}
