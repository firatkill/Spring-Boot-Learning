package com.luv2code.cruddemo.dao;


import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void addInstructor(Instructor instructor);
    void addInstructorDetail(int instructorId,InstructorDetail instructorDetail);
    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void addCourseByInstructorId(int instructorId, Course course);
    void findCoursesByInstructorId(int instructorId);


    void deleteCourseByCourseId(int i);

    void deleteInstructorByInstructorId(int i);
}
