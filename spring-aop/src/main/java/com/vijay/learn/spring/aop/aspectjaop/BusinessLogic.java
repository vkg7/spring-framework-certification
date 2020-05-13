/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.aop.aspectjaop;

import org.springframework.stereotype.Component;

@Component
public class BusinessLogic {
    public void getBusinessLogic() {
        System.out.println("*****************");
        System.out.println("In Business Logic method");
        System.out.println("*****************");
        //throw new RuntimeException();
    }
}
