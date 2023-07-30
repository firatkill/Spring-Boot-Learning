package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.repository.InstructorRepository;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService  {
    private final InstructorRepository repository;

    public InstructorService(InstructorRepository repository){
        this.repository=repository;
    }

    public Instructor save(Instructor instructor){
       return repository.save(instructor);
    }
    public Instructor findInstructorById(int instructorId){
        return repository.findById(instructorId).orElse(null);
    }
    @Transactional
    public void deleteInstructor(int instructorId){

        Optional<Instructor> instructor= repository.findById(instructorId);
        if(instructor.isPresent()){

      repository.deleteById(instructorId);
      if(instructor.get().getInstructorDetail() != null) System.out.println("Instructor "+instructorId+" with Instructor detail - "+instructor.get().getInstructorDetail().getId()+" deleted.");
      else System.out.println("Instructor "+instructorId+" without detail is deleted.");
     }
        else{
            System.out.println("delete failed.");
     }
    }

    public List<Instructor> findAllInstructors() {
        return repository.findAll();
    }

    public void saveAllInstructors(List<Instructor> instructorList) {
     List<Instructor> tempList=   repository.saveAll(instructorList);
        System.out.println(tempList.size()+" Instructors Added.");
    }


}

