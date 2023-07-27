package com.myprojectspringdatajpa.myproject.service.abstracts;

import com.myprojectspringdatajpa.myproject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);
}
