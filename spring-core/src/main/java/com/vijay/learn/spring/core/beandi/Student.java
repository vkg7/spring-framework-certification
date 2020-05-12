/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beandi;

import org.springframework.beans.factory.annotation.Value;

public class Student {
    private String id;
    private String name;

    @Value("#{hostel}")
    private Hostel hostel;

    @Value("#{hostel.city}")
    private String currentCity;

    public Student() {
    }

    //Added below constructor for autowiring by constructor example
    public Student(String id, String name, Hostel hostel) {
        this.id = id;
        this.name = name;
        this.hostel = hostel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hostel=" + hostel +
                '}';
    }
}
