package com.luv2code.springboot.thymeleafdemo.aspect;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private Logger myLogger= Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){};


    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){};


    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){};

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){};


    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        //display method we are calling
        String theMethod=theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @Before: calling method: "+theMethod);

        //display the arguments to the method

        //get the args
        Object[] args=theJoinPoint.getArgs();

        //loop thru and display args
        for(Object tempArg:args){
            if(tempArg instanceof Employee){
                myLogger.info("====> argument: "+tempArg);
            }
        }
    }


    @AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        //display method we are returning from
String theMethod=theJoinPoint.getSignature().toShortString();
 myLogger.info("====> @AfterReturning calling method: "+theMethod);


        //display data returned
        myLogger.info("====> result : "+theResult);

    }


}
