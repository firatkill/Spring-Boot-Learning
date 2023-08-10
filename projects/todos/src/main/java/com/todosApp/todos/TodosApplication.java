package com.todosApp.todos;

import com.todosApp.todos.entities.Todo;
import com.todosApp.todos.entities.User;
import com.todosApp.todos.service.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLine(TodoService service){

		return runner->{
			savetodoToDb(service);
		};
	}

	private void savetodoToDb(TodoService service) {

		User user=new User("firat","firat@gmail.com","somepassword");

		service.saveUserToDb(user);



	}

}
