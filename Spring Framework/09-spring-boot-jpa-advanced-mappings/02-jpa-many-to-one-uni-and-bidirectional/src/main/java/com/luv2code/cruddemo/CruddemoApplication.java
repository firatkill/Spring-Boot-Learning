package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
			deleteInstructor(dao);

		};
	}

	private void deleteInstructor(AppDAO dao) {
		dao.deleteInstructorByInstructorId(3);
	}

	private void deleteCourse(AppDAO dao) {
		dao.deleteCourseByCourseId(14);
	}

	private void getCourseById(AppDAO dao) {
      dao.findCoursesByInstructorId(3);
	}

	private void addCourse(AppDAO dao) {
		dao.addCourseByInstructorId(3,new Course("One more Java Coding Course"));
	}

	private void getInstructor(AppDAO dao) {
		Instructor instructor= dao.findInstructorById(3);
		System.out.println(instructor.getInstructorDetail());
	}

	private void addInstructorDetailToDB(AppDAO dao) {
		dao.addInstructorDetail(6,new InstructorDetail("youtube.com","Futbol"));
	}

	private void addInstructorToDB(AppDAO dao) {
		Instructor instructor=new Instructor("ismail","Kil","ismail@gmail.com");
		dao.addInstructor(instructor);
	}


}
