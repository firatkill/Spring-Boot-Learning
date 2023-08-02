package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass()+" DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        List<Account> myAccounts=new ArrayList<>();
        if(!tripWire) throw new RuntimeException("Error occured.");
        myAccounts.add(new Account("Fırat","Beginner"));
        myAccounts.add(new Account("Ahmet","Upper"));
        myAccounts.add(new Account("Emre","Senior"));
        myAccounts.add(new Account("Rukiye","Rookie"));
        return myAccounts;
    }


}
