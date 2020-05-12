/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beandi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Value("Honda")
    private String name;
    @Value("10000")
    private int perDayCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPerDayCost() {
        return perDayCost;
    }

    public void setPerDayCost(int perDayCost) {
        this.perDayCost = perDayCost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", perDayCost=" + perDayCost +
                '}';
    }
}
