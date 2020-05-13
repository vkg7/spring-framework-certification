/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.aop.client;

import com.vijay.learn.spring.aop.springaop.Saloon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springaop/spring-application-context-springaop.xml");

        /*// The mooseSaloon proxy
        Saloon proxySaloon = (Saloon)ctx.getBean("proxySaloon");
        proxySaloon.openSaloon();
        System.out.println("proxySaloon [" + proxySaloon.getClass() + "]");*/

        // The mooseSaloon pojo-BeanNameAutoProxyCreator
        Saloon mooseSaloon = (Saloon)ctx.getBean("mooseSaloon");
        mooseSaloon.openSaloon();
        System.out.println("mooseSaloon [" + mooseSaloon.getClass() + "]");
    }
}
