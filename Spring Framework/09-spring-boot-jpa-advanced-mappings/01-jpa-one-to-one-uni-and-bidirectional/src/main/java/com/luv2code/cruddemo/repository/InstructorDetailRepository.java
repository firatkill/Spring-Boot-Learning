package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
}
