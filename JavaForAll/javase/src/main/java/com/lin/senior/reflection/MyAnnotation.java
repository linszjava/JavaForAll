package com.lin.senior.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, CONSTRUCTOR, METHOD, LOCAL_VARIABLE, TYPE})
public @interface MyAnnotation {

    String value() default "linsz";
}
