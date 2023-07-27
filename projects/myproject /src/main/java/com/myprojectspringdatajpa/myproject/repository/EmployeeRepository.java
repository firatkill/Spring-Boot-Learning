package com.myprojectspringdatajpa.myproject.repository;


import com.myprojectspringdatajpa.myproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
