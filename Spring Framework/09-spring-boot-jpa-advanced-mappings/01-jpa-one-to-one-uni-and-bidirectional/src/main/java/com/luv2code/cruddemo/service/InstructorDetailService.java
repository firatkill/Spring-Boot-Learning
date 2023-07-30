package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.repository.InstructorDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailService  {
private InstructorDetailRepository repository;

public InstructorDetailService(InstructorDetailRepository repository){this.repository=repository;};

public InstructorDetail findInstructorDetailById(int id){
    return repository.findById(id).orElse(null);
}
public void deleteInstructorDetail(int id){
    repository.deleteById(id);
}




}
