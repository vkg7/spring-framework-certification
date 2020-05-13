/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.aop.springaop;

public class MooseSaloon implements Saloon {

    /** Welcome message */
    private String greeting;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void openSaloon() {
        System.out.println("Saloon open [" + getClass() + "/" + toString() + "]");
        System.out.println(greeting);
    }
}
