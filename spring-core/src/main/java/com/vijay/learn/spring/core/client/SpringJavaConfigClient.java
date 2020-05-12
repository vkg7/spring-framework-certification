/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.core.client;

import com.vijay.learn.spring.core.javaconfig.ApplicationConfiguration;
import com.vijay.learn.spring.core.javaconfig.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaConfigClient {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Country country = (Country) appContext.getBean("countrybean",Country.class);
        String countryName = country.getCountryName();

        System.out.println("Country name: "+ countryName);
    }
}
