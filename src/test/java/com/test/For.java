package com.test;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface For {
    Class<?>[] value();

    String desc() default "";
}
