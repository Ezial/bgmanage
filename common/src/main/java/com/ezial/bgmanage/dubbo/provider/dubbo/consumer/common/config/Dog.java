package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ezial on 2018/1/29.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dog {

    String value() default "汪汪";

}
