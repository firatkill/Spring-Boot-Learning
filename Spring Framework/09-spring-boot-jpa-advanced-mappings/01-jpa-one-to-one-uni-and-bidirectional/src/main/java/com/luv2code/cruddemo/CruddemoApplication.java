package com.luv2code.cruddemo;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.service.InstructorDetailService;
import com.luv2code.cruddemo.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
  	@Bean
	public CommandLineRunner commandLineRunner(InstructorDetailService service){
		return runner->{
			// saveInstructor(service);
			//System.out.println(getInstructor(service));
           //deleteInstructor(service);
		   //getAllInstructors(service);
			//saveAllInstructors(service);
			//mergeInstructor(service);
			//getAllInstructors(service);
			//findInstructorDetail(service);
			deleteInstructorDetail(service);
		};
	}

	private void deleteInstructorDetail(InstructorDetailService service){
		service.deleteInstructorDetail(6);
		System.out.println("deleted.");
	}
	private void findInstructorDetail(InstructorDetailService service) {
       InstructorDetail detail= service.findInstructorDetailById(5);
		System.out.println(detail.getInstructor());



	}

	private void mergeInstructor(InstructorService service) {
          List<Instructor> instructorList = service.findAllInstructors();

		  for(Instructor instructor:instructorList){
			  instructor.setInstructorDetail(new InstructorDetail("Spor",instructor.getFirstName()+"@youtube.com"));
			  service.save(instructor);
		  }



	}

	private void saveAllInstructors(InstructorService service) {
		List<Instructor> instructorList = new ArrayList<>();
		instructorList.add(new Instructor("Firat","Kil","firat@gmail.com"));
		instructorList.add(new Instructor("Beyza","Aydin","beyza@gmail.com"));
		instructorList.add(new Instructor("Cevriye","Edik","edik@gmail.com"));
		instructorList.add(new Instructor("Nida","Avci","nida@gmail.com"));
		instructorList.add(new Instructor("Sude","Cosgun","sude@gmail.com"));
		service.saveAllInstructors(instructorList);
	}

	private void getAllInstructors(InstructorService service) {
		List<Instructor> instructorList= service.findAllInstructors();

		instructorList.forEach(System.out::println);
	}


	private void deleteInstructor(InstructorService service){
		service.deleteInstructor(6);
	}
	private Instructor getInstructor(InstructorService service) {
		return service.findInstructorById(4);
	}

	private void saveInstructor(InstructorService service) {
		Instructor instructor=new Instructor("Beza","Kil","firat@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("voleybol","firat.youtube.com");

		instructor.setInstructorDetail(instructorDetail);
		service.save(instructor);


	}


}
