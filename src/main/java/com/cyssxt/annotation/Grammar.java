package com.cyssxt.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Grammar {
    String value() default "";
    Class parser() default ParserAnno.class;
    int seq() default 0;
}
