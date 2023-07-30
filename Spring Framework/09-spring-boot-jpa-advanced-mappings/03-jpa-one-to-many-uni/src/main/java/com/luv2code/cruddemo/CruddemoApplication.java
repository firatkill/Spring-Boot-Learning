package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
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

			//addInstructorToDB(dao);
			//addInstructorDetailToDB(dao);
			//getInstructor(dao);
			//addCourse(dao);
			//getCourseById(dao);
			//deleteCourse(dao);
			//deleteInstructor(dao);
           // addReview(dao);
			//deleteReview(dao);
			//updateReview(dao);
			findAllReviews(dao);
		};
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
		dao.deleteCourseByCourseId(10);
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
