/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.beanlifecycle.BeanLifeCycleAnnotations;
import com.vijay.learn.spring.core.beanlifecycle.BeanLifeCycleInterface;
import com.vijay.learn.spring.core.beanlifecycle.BeanLifeCycleXML;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifeCycleClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springcore/spring-application-context-lifecycle.xml");

        BeanLifeCycleXML beanLifeCycle = context.getBean("beanLifeCycleXML", BeanLifeCycleXML.class);
        beanLifeCycle.sayHello();

        BeanLifeCycleInterface beanLifeCycleInterface = context.getBean("beanLifeCycleInterface", BeanLifeCycleInterface.class);
        beanLifeCycleInterface.sayHello();

        BeanLifeCycleAnnotations beanLifeCycleAnnotations = context.getBean("beanLifeCycleAnnotations", BeanLifeCycleAnnotations.class);
        beanLifeCycleAnnotations.sayHello();

        ((AbstractApplicationContext)context).registerShutdownHook();
    }
}
