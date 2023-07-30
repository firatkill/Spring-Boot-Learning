package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private EmployeeService employeeService;
	@Autowired
	public EmployeeController(EmployeeService employeeService){
		this.employeeService=employeeService;
	}





	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		List<Employee> employeeList=employeeService.findAll();
		theModel.addAttribute("employees", employeeList);

		return "list-employees";
	}
	@GetMapping("/showformforadd")
	public String showAddForm(Model theModel){
         Employee employee=new Employee();
		 theModel.addAttribute("employee",employee);
		return "addForm";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.save(employee);
		return "redirect:/employees/list";
	}
	@GetMapping("/{employeeId}/update")
	public String showupdateForm(@PathVariable int employeeId,Model theModel){
		Employee employee=employeeService.findById(employeeId);
		theModel.addAttribute("employee",employee);
				return "updateForm";
	}

	@PostMapping("/{employeeId}/update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee , @PathVariable int employeeId){
		Employee employee1=employeeService.findById(employeeId);
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setEmail(employee.getEmail());
		employee1.setId(employeeId);
		employeeService.save(employee1);
		return "redirect:/employees/list";
	}
	@GetMapping("/{employeeId}/delete")
	public String deleteEmployee(@PathVariable int employeeId){
		employeeService.deleteById(employeeId);
		return "redirect:/employees/list";

	}
}









