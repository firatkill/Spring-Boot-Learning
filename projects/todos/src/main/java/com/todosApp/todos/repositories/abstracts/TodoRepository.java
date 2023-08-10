package com.todosApp.todos.repositories.abstracts;


import com.todosApp.todos.entities.User;

public interface TodoRepository {
    User saveUser(User user);
}
