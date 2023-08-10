package com.todosApp.todos.repositories.concretes;

import com.todosApp.todos.entities.Todo;
import com.todosApp.todos.entities.User;
import com.todosApp.todos.repositories.abstracts.TodoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private EntityManager entityManager;

    @Autowired
    public TodoRepositoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public User saveUser(User user){
        entityManager.persist(user);
        return entityManager.find(User.class,user);
    }



}
