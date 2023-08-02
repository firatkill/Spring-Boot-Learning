package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterReturningAspect {

    //getting returning value:
  /*
    @AfterReturning(value = "execution(* findAccounts(..))",returning = "returningresult")
    public void getReturningValue(List<Account> returningresult){

        returningresult.forEach(System.out::println);

    }
   */


    //modifying returning value:
    @AfterReturning(value = "execution(* findAccounts(..))",returning = "returningresult")
    public void getReturningValue(List<Account> returningresult){

        Account tempAccount=returningresult.get(2);
        tempAccount.setName("New Name for Returning Account");
        returningresult.forEach(System.out::println);

    }


}
