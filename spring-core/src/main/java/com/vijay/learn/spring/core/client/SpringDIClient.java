/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.beandi.CollectionsDI;
import com.vijay.learn.spring.core.beandi.Student;
import com.vijay.learn.spring.core.beandi.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDIClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springcore/spring-application-context-di.xml");
        //Dependency Injection example where User HAS-A relationship with Car
        User user = context.getBean("user", User.class);
        System.out.printf("User '%s' has car named '%s' with per day cost at Rs. %d. %n",user.getUserName(),user.getCar().getName(),user.getCar().getPerDayCost());

        Student student = context.getBean("student", Student.class);
        System.out.printf("student : %s %n",student.toString());

        Student studentInnerBean = context.getBean("studentInnerBean", Student.class);
        System.out.printf("studentInnerBean : %s %n",studentInnerBean.toString());

        Student student_alias = context.getBean("student_alias", Student.class);
        System.out.printf("student_alias : %s %n",student_alias.toString());

        Student studentIdRef = context.getBean("studentIdRef", Student.class);
        System.out.printf("studentIdRef : %s %n",studentIdRef.toString());

        CollectionsDI collectionsDI = context.getBean("collectionsDI", CollectionsDI.class);
        System.out.printf("collectionsDI : %s %n",collectionsDI.toString());
    }
}
