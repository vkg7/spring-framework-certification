/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.beandi.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAutoWiringClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springcore/spring-application-context-autowiring.xml");

        //Autowiring byName
        Student studentAutoWiringByName = context.getBean("studentAutoWiringByName", Student.class);
        System.out.printf("studentAutoWiringByName : %s %n",studentAutoWiringByName.toString());

        //Autowiring byName
        Student studentAutoWiringByType = context.getBean("studentAutoWiringByType", Student.class);
        System.out.printf("studentAutoWiringByType : %s %n",studentAutoWiringByType.toString());

        //Autowiring constructor
        Student studentAutoWiringByConstructor = context.getBean("studentAutoWiringByConstructor", Student.class);
        System.out.printf("studentAutoWiringByConstructor : %s %n",studentAutoWiringByConstructor.toString());


    }
}
