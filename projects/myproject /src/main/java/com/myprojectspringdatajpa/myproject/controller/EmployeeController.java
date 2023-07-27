package com.myprojectspringdatajpa.myproject.controller;

import com.myprojectspringdatajpa.myproject.entity.Employee;
import com.myprojectspringdatajpa.myproject.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return  employeeService.findAll();
    }

    @PostMapping("")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

}
