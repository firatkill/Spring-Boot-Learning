package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstructorDAOImpl implements InstructorDAO{
    private EntityManager entityManager;
    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor instructor) {
       entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(Instructor instructor) {
        return entityManager.find(Instructor.class,instructor);
    }
}
