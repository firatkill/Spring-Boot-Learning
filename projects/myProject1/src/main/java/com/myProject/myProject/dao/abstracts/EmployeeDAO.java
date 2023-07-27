package com.myProject.myProject.dao.abstracts;

import com.myProject.myProject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);
    Employee findEmployeeById(int id);

    List<Employee> findAllEmployees();

    void deleteEmployee(int employeeId);
    void updateEmployee(int id,Employee employee);


}
