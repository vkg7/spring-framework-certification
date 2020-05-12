/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beandi;

public class User {
    private String userName;
    Car car;

    //Constructor based injection
    public User(Car car) {
        this.car = car;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Car getCar() {
        return car;
    }

    //Setter based injection
    public void setCar(Car car) {
        this.car = car;
    }
}
