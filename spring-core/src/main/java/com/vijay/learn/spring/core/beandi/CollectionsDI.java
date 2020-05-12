/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.beandi;

import java.util.List;

public class CollectionsDI {
    private List<String> listOfStudents;

    public List<String> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<String> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    @Override
    public String toString() {
        return "CollectionsDI{" +
                "listOfStudents=" + listOfStudents +
                '}';
    }
}
