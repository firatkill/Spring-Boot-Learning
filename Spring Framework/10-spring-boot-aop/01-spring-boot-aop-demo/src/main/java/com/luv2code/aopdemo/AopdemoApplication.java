package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO dao) {

		return runner ->{
			//demoTheBeforeAdvice(dao);
			//demoTheAfterReturningAdvice(dao);
			//demoTheAfterThrowingAdvice(dao);
			getFortuneForTheAroundAspect();
			System.out.println("finished");
		};
	}

	private void getFortuneForTheAroundAspect() {
		System.out.println(getFortune());;
	}

	public String getFortune() {
	return	 "today will be a good day for you!";

	}

	private void demoTheAfterThrowingAdvice(AccountDAO dao) {
		List<Account> accounts=null;
	try{
		//add a boolean flag to simulate exception
		boolean tripWire=false;
		 accounts=dao.findAccounts(tripWire);

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");

	}catch (Exception exc){
		System.out.println("\n\nMain Program: caught exception: "+exc);
	}
		System.out.println("--------");

		System.out.println(accounts);

		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO dao) {
		dao.findAccounts(true);
	}

	private void demoTheBeforeAdvice(AccountDAO dao) {
		Account account= new Account("Fırat","Beginner");
		dao.addAccount(account);
	}

}
