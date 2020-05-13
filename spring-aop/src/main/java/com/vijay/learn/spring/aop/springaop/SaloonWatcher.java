/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.aop.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SaloonWatcher implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MethodBeforeAdvice - "+method.getName() + " called on " + target);
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturningAdvice - "+method.getName() + " called on " + target+" with returnvalue as "+returnValue);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object object;

        System.out.println("invoke - Before Proceed..");
        object = methodInvocation.proceed();
        System.out.println("invoke - After Proceed..");
        return object;
    }
}
