/*
 * Copyright (c) 2020. All rights reserved .
 * This code developed by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework Certification Training
 */

package com.vijay.learn.spring.aop.aspectjaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /*@Before  :
    lets say you have some business logic class (BusinessLogic.java) and you want to do logging before execution of getBusinessLogic method of this class.*/
    @Before("execution(* com.vijay.learn.spring.aop.aspectjaop.BusinessLogic.getBusinessLogic(..))")
    public void loggingBeforeBusinessLogic(JoinPoint joinPoint){
        System.out.println("loggingBeforeBusinessLogic() - Before execution of method : " + joinPoint.getSignature().getName());
    }

    /*@After:
    This method will execute after execution of actual business logic, so LoggingAspect.java will look something like this.*/
    @After("execution(* com.vijay.learn.spring.aop.aspectjaop.BusinessLogic.getBusinessLogic(..))")
    public void loggingAfterBusinessLogic(JoinPoint joinPoint) {
        System.out.println("loggingAfterBusinessLogic() - After execution of method : " + joinPoint.getSignature().getName());
    }
    /*@AfterReturning:
    This method will execute after execution of actual business logic but only if it successfully returns.*/
    @AfterReturning("execution(* com.vijay.learn.spring.aop.aspectjaop.BusinessLogic.getBusinessLogic(..))")
    public void loggingAfterReturningBusinessLogic(JoinPoint joinPoint) {
        System.out.println("loggingAfterReturningBusinessLogic() - After Returning execution of method : " + joinPoint.getSignature().getName());
    }

    /*@AfterThrowing:
    It will execute if any exception occurs in getBusinessLogic method.*/
    @AfterThrowing("execution(* com.vijay.learn.spring.aop.aspectjaop.BusinessLogic.getBusinessLogic(..))")
    public void loggingAfterBusinessLogicException(JoinPoint joinPoint) {
        System.out.println("loggingAfterBusinessLogicException() - Exception occurred in getBusinessLogic method");
    }

    /*@Around:
    Method with @Around will get called before and after execution of business logic.
    You need to call reference of ProceedingJoinPoint and call proceed method to execute actual business logic.*/
    @Around("execution(* com.vijay.learn.spring.aop.aspectjaop.BusinessLogic.getBusinessLogic(..))")
    public void loggingAroundBusinessLogic(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("loggingAroundBusinessLogic() - Before calling actual business logic"); // Before running actual business logicic
        joinPoint.proceed(); // business logic method get executed
        System.out.println("loggingAroundBusinessLogic() - After calling actual business logic"); // After running actual business logic
    }
}
/*
* Result is:
*
*
loggingAroundBusinessLogic() - Before calling actual business logic
loggingBeforeBusinessLogic() - Before execution of method : getBusinessLogic
*****************
In Business Logic method
*****************
loggingAroundBusinessLogic() - After calling actual business logic
loggingAfterBusinessLogic() - After execution of method : getBusinessLogic
loggingAfterReturningBusinessLogic() - After Returning execution of method : getBusinessLogic
*/



