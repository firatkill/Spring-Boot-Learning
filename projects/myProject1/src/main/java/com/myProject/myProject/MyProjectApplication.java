package com.myProject.myProject;


import com.myProject.myProject.dao.abstracts.EmployeeDAO;
import com.myProject.myProject.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);

	}

   	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO){
		return runner -> {
			System.out.println("Hello world!");
            
		};
	}




}
