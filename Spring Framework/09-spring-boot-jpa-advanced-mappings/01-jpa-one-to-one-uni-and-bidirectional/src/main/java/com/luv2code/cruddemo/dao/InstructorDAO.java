package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import org.springframework.stereotype.Component;


public interface InstructorDAO {
    void save(Instructor instructor);
    Instructor findById(Instructor instructor);


}
