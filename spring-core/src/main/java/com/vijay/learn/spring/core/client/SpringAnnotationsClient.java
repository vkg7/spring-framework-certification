/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.annotations.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationsClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springcore/spring-application-context-annotations.xml");

        Employee employee = context.getBean("employee", Employee.class);
        System.out.printf("Employee details = %s :%n",employee.toString());
    }
}
