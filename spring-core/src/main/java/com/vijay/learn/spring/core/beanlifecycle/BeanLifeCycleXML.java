/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beanlifecycle;

public class BeanLifeCycleXML {
    public BeanLifeCycleXML() {
        System.out.println("BeanLifeCycleXML Class Constructor called.");
    }

    public void init(){
        System.out.println("BeanLifeCycleXML Class init method called.");
    }

    public void sayHello(){
        System.out.println("BeanLifeCycleXML: Hello! Welcome to Spring Bean Life Cycle Example.");
    }

    public void destroy(){
        System.out.println("BeanLifeCycleXML Class destroy method called.");
    }
}
