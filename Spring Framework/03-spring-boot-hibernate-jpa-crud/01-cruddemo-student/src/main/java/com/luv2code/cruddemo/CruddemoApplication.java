package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.hibernate.engine.spi.EntityEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {




	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}



	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
             //create student(studentDAO)

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=2;

		studentDAO.delete(studentId);

		List<Student> allStudents=studentDAO.findAll();

		allStudents.forEach(System.out::println);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id:"+studentId);
		Student myStudent=studentDAO.findById(studentId);

		// change first name to "scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		//update the student
		System.out.println("merging student...");
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a List of Students
		List<Student> theStudents=studentDAO.findByLastName("Kil");

		//display List of Students

		theStudents.forEach(System.out::println);

	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get List of Students
		List<Student> newList=studentDAO.findAll();

		//print all students
		newList.forEach(System.out::println);

	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Daffy","Duck","daffy@luv2code.com");

		//save the student
		System.out.println("saving student...");
		studentDAO.save(tempStudent);

		//display id of the saved student

		int theId=tempStudent.getId();
		System.out.println("saved student. Generated id: "+theId);

		//retrieve student based on the id: primary key
		System.out.println("retrieveing the student with id of "+theId);
		Student savedStudent= studentDAO.findById(theId);

		//display student
		System.out.println(savedStudent);
	}


	private void createMultipleStudents(StudentDAO studentDAO){
		//create multiple students
		System.out.println("Creating 3 Students...");
		Student tempStudent1= new Student("John","Kil","paul@luv2code.com");
		Student tempStudent2= new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3= new Student("Bonita","Applebum","bonita@luv2code.com");

		//save the student objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}



	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent= new Student("Firat","Kil","paul@luv2code.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);


		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}


}
