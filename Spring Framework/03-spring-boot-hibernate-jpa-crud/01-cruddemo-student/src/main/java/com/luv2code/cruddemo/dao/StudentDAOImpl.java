package com.luv2code.cruddemo.dao;


import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
private final EntityManager entityManager;


//define constructor injection for entitymanager
@Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager=entityManager;

    }


    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }
    public List<Student> findAll(){
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

    //create query
    TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData ",Student.class);


    //set query parameters
    theQuery.setParameter("theData",theLastName);

    //return results
    return theQuery.getResultList() ;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {

    Student theStudent=entityManager.find(Student.class,id);

    entityManager.remove(theStudent);



    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
