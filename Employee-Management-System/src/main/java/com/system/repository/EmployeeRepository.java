package com.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
