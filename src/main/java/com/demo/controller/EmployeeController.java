package com.demo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@PostMapping(value= "/create")
	public String create(@RequestBody List<Employee> employee) {
		employeeService.createEmployee(employee);
		return "Employee records created.";
	}

	@GetMapping(value= "/getall")
	public Collection<Employee> getAll() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(value= "/getbyid/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value= "employee-id") int id) {
		return employeeService.findEmployeeById(id);
	}

	@PutMapping(value= "/update/{employee-id}")
	public String update(@PathVariable(value= "employee-id") int id, @RequestBody Employee employee) {
		employee.setId(id);
		employeeService.updateEmployee(employee);
		return "Employee record for employee-id= " + id + " updated.";
	}


	@DeleteMapping(value= "/delete/{employee-id}")
	public String delete(@PathVariable(value= "employee-id") int id) {
		employeeService.deleteEmployeeById(id);
		return "Employee record for employee-id= " + id + " deleted.";
	}

}
