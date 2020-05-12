/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifeCycleAnnotations {

    public BeanLifeCycleAnnotations() {
        System.out.println("BeanLifeCycleAnnotations Class Constructor called.");
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct: I am in the init method and I work after bean instantiation.");
    }
    public void sayHello(){
        System.out.println("BeanLifeCycleAnnotations: Hello! Welcome to Spring Bean Life Cycle Example.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PreDestroy: I am the destroy method and I work just before bean destroyed.");
    }
}
