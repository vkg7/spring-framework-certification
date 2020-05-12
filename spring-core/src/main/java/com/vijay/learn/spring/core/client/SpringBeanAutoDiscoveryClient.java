/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.beanautodiscovery.BeanAutoDiscovery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanAutoDiscoveryClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springcore/spring-application-context-autodiscovery.xml");

        BeanAutoDiscovery beanAutoDiscovery = applicationContext.getBean("beanAutoDiscovery", BeanAutoDiscovery.class);
        beanAutoDiscovery.sayHello();
    }


}
