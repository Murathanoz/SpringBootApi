package com.springboot.crudexample.service;

import java.util.List;
import java.util.Map;

import com.springboot.crudexample.employeeDto.EmployeeDto;
import com.springboot.crudexample.model.Employee;

public interface EmployeeService {
	EmployeeDto getEmplyeeById(long id);
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmplyeeById(long id,EmployeeDto employeeDetails);
	Map<String,Boolean> deleteEmployee(long id);
	List<EmployeeDto> fildAllEmployee();
}
