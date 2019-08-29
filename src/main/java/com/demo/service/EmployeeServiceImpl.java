package com.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.EmployeeDAO;
import com.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDao;

	@Override
	public void createEmployee(List<Employee> employee) {
		employeeDao.saveAll(employee);

	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeDao.deleteById(id);

	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.save(employee);

	}

}