package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspectCombiningPointcuts {
/*

    //matches every method with any parameter and any return value inside dao package
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}


    //only applies to getter methods inside dao package
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*())")
    private void getters(){}

    //only applies to setter methods inside dao package
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*())")
    private void setters(){}

    //inside dao package, any type of method thats not setter or getter
    @Pointcut("forDaoPackage() && !(getters() || setters())")
    private void forDaoPackageNoGetterSetters(){}

    //apply!
    @Before("forDaoPackageNoGetterSetters()")
    public void writeBefore(){
        System.out.println("Combined Pointcut Works!");
    }

    */
}
