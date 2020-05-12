/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.beaninheritance.Father;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInheritanceClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springcore/spring-application-context-inheritance.xml");

        Father father = context.getBean("father", Father.class);
        System.out.printf("Bean Inheitance - Father's name is %s %s : %n",father.getFirstName(),father.getLastName());

        Father child = context.getBean("child", Father.class);
        System.out.printf("Bean Inheitance - Child's name %s %s : %n",child.getFirstName(),child.getLastName());
    }
}
