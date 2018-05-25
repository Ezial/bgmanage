/**
 * Copyright(c) 2013-2013 by Puhuifinance Inc.
 * All Rights Reserved
 */
package com.ezial.bgmanage.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextHolder implements ApplicationContextAware {
    
    /**
     * 以静态变量保存ApplicationContext,可在任意代码中取出ApplicaitonContext.
     */
    private static ApplicationContext context;
    
    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.context = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }
    
    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T)context.getBean(name);
    }
    
}
