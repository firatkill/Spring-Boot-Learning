package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspectMethodArguments {
 /*
    @Order(-500)
    @Before("execution(void addAccount(..))")
    public void methodMetadataAdvice(JoinPoint joinPoint){

        // 'joinPoint' gives the metadata about the method.

        //getting arguments
        for(var arg : joinPoint.getArgs()){
            System.out.println(arg);
            if(arg instanceof  Account){
                System.out.println("account name in arguments: "+ ((Account) arg).getName());
            }
        }
 //getting method signature
        MethodSignature method= (MethodSignature) joinPoint.getSignature();
        System.out.println(method);

    }

    @Before("execution(void methodMetadataAdvice(..))")
    public void beforeAnAdvice(){
        System.out.println("Before an advice");
    }

  */
}
