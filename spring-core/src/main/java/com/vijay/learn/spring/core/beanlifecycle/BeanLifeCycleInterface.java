/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycleInterface implements InitializingBean, DisposableBean {

    public BeanLifeCycleInterface() {
        System.out.println("BeanLifeCycleInterface Class Constructor called.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I am in the afterPropertiesSet method and I work after bean instantiation.");
    }

    public void sayHello(){
        System.out.println("BeanLifeCycleInterface: Hello! Welcome to Spring Bean Life Cycle Example.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("I am the destroy method and I work just before bean destroyed.");
    }
}
