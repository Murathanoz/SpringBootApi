package com.springboot.crudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudexample.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
