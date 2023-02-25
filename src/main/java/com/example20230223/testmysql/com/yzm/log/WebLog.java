package com.example20230223.testmysql.com.yzm.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: yzm
 * @Date: 2023/2/25 - 02 - 25 - 10:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface WebLog {
    String desc() default "";
}
