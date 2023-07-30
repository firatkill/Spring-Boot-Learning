package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    private final EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void addInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }
    public Instructor findInstructorById(int id){
        return entityManager.find(Instructor.class,id);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void addCourseByInstructorId(int instructorId, Course course) {
        Instructor instructor=entityManager.find(Instructor.class,instructorId);
        course.setInstructor(instructor);
        entityManager.persist(course);
    }

    public void findCoursesByInstructorId(int instructorId){
        TypedQuery<Course> typedQuery= entityManager.createQuery("SELECT c FROM Course c WHERE c.instructor.id  = ?1", Course.class);
        typedQuery.setParameter(1, instructorId);
        List<Course> courseList= typedQuery.getResultList();

        courseList.forEach(System.out::println);


    }

    @Override
    @Transactional
    public void deleteCourseByCourseId(int i) {
        Course course=entityManager.find(Course.class,i);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void deleteInstructorByInstructorId(int i) {
        Instructor instructor=entityManager.find(Instructor.class,i);
        List<Course> courses=instructor.getCourses();
        courses.forEach(course->course.setInstructor(null));
        entityManager.remove(instructor);

    }

    @Override
    @Transactional
    public void addInstructorDetail(int instructorId,InstructorDetail instructorDetail) {
        Instructor instructor=entityManager.find(Instructor.class,instructorId);
        instructor.setInstructorDetail(instructorDetail);
        entityManager.merge(instructor);

    }

}
