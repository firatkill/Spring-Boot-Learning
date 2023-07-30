package com.luv2code.cruddemo.dao;


import com.luv2code.cruddemo.entity.*;

public interface AppDAO {

    void addInstructor(Instructor instructor);
    void addInstructorDetail(int instructorId,InstructorDetail instructorDetail);
    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void addCourseByInstructorId(int instructorId, Course course);
    void findCoursesByInstructorId(int instructorId);


    void deleteCourseByCourseId(int i);

    void deleteInstructorByInstructorId(int i);

    void addReviewByCourseId(int courseId,Review review);

    void deleteReviewByReviewId(int i);
    void updateReview(Review review);
    Review findReviewById(int id);

    void findAllReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void addCourseByStudentId(int i,Course course);

    void deleteStudentById(int i);
}
