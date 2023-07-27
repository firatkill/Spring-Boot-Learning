package com.myProject.myProject.dao.concretes;

import com.myProject.myProject.dao.abstracts.EmployeeDAO;
import com.myProject.myProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        if(employee.getId()==0){
            entityManager.persist(new Employee(employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail()
                    ));
        }else{
            entityManager.persist(employee);
        }

    }

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> empQuery= entityManager.createQuery("FROM Employee ",Employee.class);

        return empQuery.getResultList();


    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        Employee temp=findEmployeeById(employeeId);
        entityManager.remove(temp);

    }

    @Override
    @Transactional
    public void updateEmployee(int id,Employee employee) {
        Employee temployee=findEmployeeById(id);
        temployee.setFirstName(employee.getFirstName());
        temployee.setLastName(employee.getLastName());
        temployee.setEmail(employee.getEmail());
        entityManager.merge(temployee);
    }


}
