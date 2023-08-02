package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspectOrderedAspects {

    //orders can be between max_integer and min_integer values.

   /*
    @Order(-500)
    @Before("execution(void addAccount(..))")
    public void firstAdviceBefore(){
        System.out.println("This is the aspect with order 1");
    }
    @Order(2)
    @Before("execution(void addAccount(..))")
    public void secondAdviceBefore(){
        System.out.println("This is the aspect with order 2");
    }
    @Order(20)
    @Before("execution(void addAccount(..))")
    public void thirdAdviceBefore(){
        System.out.println("This is the aspect with order 20");
    }
    */
}
