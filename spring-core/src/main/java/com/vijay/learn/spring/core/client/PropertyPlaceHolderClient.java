/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.externalization.JdbcDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyPlaceHolderClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springcore/spring-application-context-autodiscovery.xml");
        JdbcDataSource datasource = context.getBean("datasource", JdbcDataSource.class);
        System.out.printf("Database driver name : %s %n", datasource.getDrivername());
        System.out.printf("Database user name : %s %n", datasource.getUsername());
        System.out.printf("Database password: %s %n", datasource.getPassword());
    }
}
