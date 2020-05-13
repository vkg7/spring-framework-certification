/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.aop.client;

import com.vijay.learn.spring.aop.aspectjaop.BusinessLogic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAspectJAOPClient {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("aspectjaop/spring-application-context-aspectjaop.xml");
        BusinessLogic businessLogic = (BusinessLogic) appContext.getBean("businessLogic");
        businessLogic.getBusinessLogic();
    }
}
