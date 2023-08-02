package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAroundAspect {


    @Around("execution(* com.luv2code.aopdemo.AopdemoApplication.getFortune*())")
    public Object aroundFortune(ProceedingJoinPoint pjp) throws Throwable {

        String method=pjp.getSignature().toShortString();

        Object result=null;

   try{
       result=pjp.proceed();

   }catch(Exception exc){
       System.out.println("@Around advice throws exception: "+exc);
       result="Default Fortune";
   }
   return "result";


    }
}
