package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.*;
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
    public void addReviewByCourseId(int courseId, Review review) {
        Course course= entityManager.find(Course.class,courseId);
        course.addReview(review);
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteReviewByReviewId(int i) {
        Review tempReview=entityManager.find(Review.class,i);
        entityManager.remove(tempReview);
    }
    @Override
    @Transactional
    public void updateReview(Review review){
        entityManager.merge(review);
    }

    @Override
    public Review findReviewById(int id) {
     return entityManager.find(Review.class,id);
    }

    @Override
    public void findAllReviewsByCourseId(int i) {
        System.out.println("create Query");
        TypedQuery<Review> query= entityManager.createQuery("SELECT u FROM Review u WHERE u.course.id = ?1",Review.class);
        System.out.println("set parameter:");
        query.setParameter(1,i);
        System.out.println("get list reviews");
        List<Review> reviewList = query.getResultList();

        reviewList.forEach(System.out::println);

    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        //create query

        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c FROM Course c "+
                        "JOIN FETCH c.students "+
                        "WHERE c.id = :data",Course.class);

        query.setParameter("data",id);

        //execute query
        Course course = query.getSingleResult();

        return course;

    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :givenId", Student.class
        );
        query.setParameter("givenId",id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void addCourseByStudentId(int i,Course course) {
        Student student=entityManager.find(Student.class,i);
        student.addCourse(course);
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int i) {
     Student student=entityManager.find(Student.class,i);
     entityManager.remove(student);
        System.out.println("Deleted.");
    }


    @Override
    @Transactional
    public void addInstructorDetail(int instructorId,InstructorDetail instructorDetail) {
        Instructor instructor=entityManager.find(Instructor.class,instructorId);
        instructor.setInstructorDetail(instructorDetail);
        entityManager.merge(instructor);

    }

}
