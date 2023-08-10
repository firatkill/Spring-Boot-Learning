package com.todosApp.todos.service;

import com.todosApp.todos.entities.User;
import com.todosApp.todos.repositories.abstracts.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository repository;

    public  TodoService(TodoRepository repository ){this.repository=repository;}


    @Transactional
    public void saveUserToDb(User user){
        System.out.println(repository.saveUser(user));;
    }
}
