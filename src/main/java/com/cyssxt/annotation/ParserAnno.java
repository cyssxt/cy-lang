package com.cyssxt.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParserAnno {
    String value() default "";
}
