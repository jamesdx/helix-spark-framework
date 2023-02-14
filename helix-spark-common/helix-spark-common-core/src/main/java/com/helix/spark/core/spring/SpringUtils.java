package com.helix.spark.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.hgplan.cn
 * 必要条件： 请在 SpringBoot 启动类，调用 SpringUtils#setContext(ApplicationContext applicationContext) 方法
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.hgplan.cn Inc. All rights reserved.
 * @date 2023/2/13 15:22
 **/
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.context == null) {
            context = applicationContext;
        }
    }

    /**
     * 必要条件： 请在 SpringBoot 启动类，调用 SpringUtils#setContext(ApplicationContext applicationContext) 方法
     *
     * @param applicationContext
     * @return void
     * @author Allen Wang
     * @date 2023/2/14 09:56
     */

    public static void setContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    /**
     * 通过字节码获取
     *
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    /**
     * 通过BeanName获取
     *
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

    /**
     * 通过beanName和字节码获取
     *
     * @param name
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> beanClass) {
        return context.getBean(name, beanClass);
    }
}