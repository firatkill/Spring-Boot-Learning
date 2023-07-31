package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
  	@Bean
	public CommandLineRunner commandLineRunner(AppDAO dao){
		return runner->{

        // createCourseAndStudents(dao);

			//findCourseAndStudents(dao);
			//findStudentAndCourses(dao);
			//addCourseToAStudent(dao);
			//deleteStudent(dao);
			deleteCourse(dao);
		};
	}

	private void deleteStudent(AppDAO dao) {
		dao.deleteStudentById(9);

	}

	private void addCourseToAStudent(AppDAO dao) {
		Course course= new Course("Backend Development With NodeJS");
		dao.addCourseByStudentId(3,course);
	}

	private void findStudentAndCourses(AppDAO dao) {
		int id=3;
		Student student=dao.findStudentAndCoursesByStudentId(id);
		List<Course> courses=student.getCourses();

		System.out.println("Student with the given id is: "+student);
		System.out.println("Courses of student: "+courses);

		System.out.println("Done!");

	}

	private void findCourseAndStudents(AppDAO dao) {
		int id=10;
		Course tempCourse=dao.findCourseAndStudentsByCourseId(id);
		System.out.println("Loaded Course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());

		System.out.println("Done!");
	}


	private void createCourseAndStudents(AppDAO dao) {
		// create a course
          Course course = new Course("React Web Design");

		//create students

		Student student1=new Student("firat","kil","firat@gmail.com");
		Student student2=new Student("ismail","kil","ismail@gmail.com");
		Student student3=new Student("beyza","aydin","beyza@gmail.com");

		//add students to the course
         course.setStudents(List.of(student1,student2,student3));
		 //create instructor for course

		//save the course and associated students

		dao.addCourseByInstructorId(1,course);


	}

	private void findAllReviews(AppDAO dao) {
		dao.findAllReviewsByCourseId(11);
	}

	private void updateReview(AppDAO dao) {
        Review tempReview=dao.findReviewById(6);
		tempReview.setComment("Not good at all.");
		dao.updateReview(tempReview);
	}

	private void deleteReview(AppDAO dao) {
		dao.deleteReviewByReviewId(5);
	}

	private void addReview(AppDAO dao) {
		dao.addReviewByCourseId(11,new Review("Nice Course!"));
	}

	private void deleteInstructor(AppDAO dao) {
		dao.deleteInstructorByInstructorId(3);
	}

	private void deleteCourse(AppDAO dao) {
		dao.deleteCourseByCourseId(13);
	}

	private void getCourseById(AppDAO dao) {
      dao.findCoursesByInstructorId(3);
	}

	private void addCourse(AppDAO dao) {
		dao.addCourseByInstructorId(1,new Course("Java Fundamentals"));
	}

	private void getInstructor(AppDAO dao) {
		Instructor instructor= dao.findInstructorById(3);
		System.out.println(instructor.getInstructorDetail());
	}

	private void addInstructorDetailToDB(AppDAO dao) {
		dao.addInstructorDetail(1,new InstructorDetail("youtube.com","Futbol"));
	}

	private void addInstructorToDB(AppDAO dao) {
		Instructor instructor=new Instructor("Firat","Kil","firat@gmail.com");
		dao.addInstructor(instructor);
	}


}
