package com.system.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.model.Employee;
import com.system.repository.EmployeeRepository;

@Service
public class EmployeeserviceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> option=employeeRepository.findById(id);
		Employee employee=null;
		if(option.isPresent()) {
			employee=option.get();
		}
		else {
			throw new RuntimeException("Employee Not Found For id :: "+id);
			
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		
	}

	
		
	
	
	

}
