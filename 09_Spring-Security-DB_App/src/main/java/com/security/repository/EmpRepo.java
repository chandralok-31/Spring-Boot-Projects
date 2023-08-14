package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entity.Employee;

public interface EmpRepo  extends JpaRepository<Employee, Integer>{

	public Employee findByEmail(String email);
}
