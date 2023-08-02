package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAfterThrowingAspect {

 /*
    @AfterThrowing(value = "execution(* findAccounts(..))",throwing = "exc")
    public void doThrowingStuff(JoinPoint theJoinPoint, Throwable exc){
        System.out.println("afterthrowing aspect get the exception: "+exc.getMessage());

    }
  */

}
