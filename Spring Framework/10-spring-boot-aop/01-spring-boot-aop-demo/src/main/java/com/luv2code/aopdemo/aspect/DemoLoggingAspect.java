package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with a @Before advice



    /*
    exact path Advice:
    @Before("execution( void com.luv2code.aopdemo.dao.AccountDAOImpl.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("Advice Worked!");
    }
  */
    /*
    Any method inside AccountDAOImpl class:

    @Before("execution(void com.luv2code.aopdemo.dao.AccountDAOImpl.*())")
    public void beforeAddAccountAdvice(){
        System.out.println("Advice worked!");
    }
*/

 /*
  Any method with return type void, public type and named 'addAccount'
  @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("Advice worked");
    }
*/
/*
     Any method type void with starting 'add' name
    @Before("execution(void add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("Advice Worked!");
    }
  */
  /*
   Any method starting with 'add' with any return type:

    @Before("execution(* add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("Advice Worked!");
    }
*/
    /*
      Advices on methods with parameter // parameter with full path:

    @Before("execution(* add*(com.luv2code.aopdemo.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println("Advice Worked!");
    }
*/
    /*
          Advices on methods with parameter // parameter can be all classes inside aopdemo package: :

 @Before("execution(* add*(com.luv2code.aopdemo.*))")
 public void beforeAddAccountAdvice(){
     System.out.println("Advice Worked!");
 }

*/

        /*
          Advices on methods with parameter // parameter can be anything:: :

 @Before("execution(* add*(*))")
 public void beforeAddAccountAdvice(){
     System.out.println("Advice Worked!");
 }

*/
}
