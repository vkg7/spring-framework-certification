/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beanautodiscovery;

import org.springframework.stereotype.Component;

@Component//("beanAutoDiscovery")
public class BeanAutoDiscovery {
    public void sayHello(){
        System.out.println("BeanAutoDiscovery: Hello! Welcome to Spring Bean Auto Discovery Example - using @Component annotation");
    }
}
