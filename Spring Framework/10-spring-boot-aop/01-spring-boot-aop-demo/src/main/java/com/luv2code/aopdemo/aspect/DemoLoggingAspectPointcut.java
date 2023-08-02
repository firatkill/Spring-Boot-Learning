package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspectPointcut {

 /*
    @Pointcut("execution(void addAccount(..))")
    private void addAccountPointcut(){};

    @Before("addAccountPointcut()")
    public void beforeAddAccountAdvice(){
        System.out.println("Pointcut Advice Working!");
    }

  */

}
