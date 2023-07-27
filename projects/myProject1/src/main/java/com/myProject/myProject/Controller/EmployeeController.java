package com.myProject.myProject.Controller;

import com.myProject.myProject.dao.abstracts.EmployeeDAO;
import com.myProject.myProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeDAO.findAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return employeeDAO.findEmployeeById(employeeId);

    }
    @PostMapping("")
    public void createEmployee(@RequestBody Employee employee){

        employee.setId(0);
        employeeDAO.saveEmployee(employee);

    }
    @DeleteMapping("")
    public void deleteEmployee(@RequestBody Employee employee){

        employeeDAO.deleteEmployee(employee.getId());
    }


}
