package com.demo.controller;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@PostMapping(value= "/create")
	public String create(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return "Employee has been created.";
	}

	@GetMapping(value= "/getall")
	public Collection<Employee> getAll() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(value= "/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value= "employee-id") int id) {
		return employeeService.findEmployeeById(id);
	}

	@DeleteMapping(value= "/delete/{employee-id}")
	public String delete(@PathVariable(value= "employee-id") int id) {
		employeeService.deleteEmployeeById(id);
		return "Employee record for employee-id= " + id + " deleted.";
	}

}
