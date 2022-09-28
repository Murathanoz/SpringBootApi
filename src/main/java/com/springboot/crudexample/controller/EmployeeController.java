package com.springboot.crudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudexample.employeeDto.EmployeeDto;
import com.springboot.crudexample.exception.ResourceNotFounfException;
import com.springboot.crudexample.model.Employee;

import com.springboot.crudexample.repository.EmployeeRepository;
import com.springboot.crudexample.service.EmployeeServiceImp;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImp employeeService;
	
	
	@GetMapping("/employees")
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.fildAllEmployee();
	}
	
	@PostMapping("/employees")
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {
	return employeeService.createEmployee(employee);	
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> getEmplyeeById(@PathVariable long id) {
		EmployeeDto employeeDto=employeeService.getEmplyeeById(id);		
		return ResponseEntity.ok(employeeDto);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> updateEmplyeeById(@PathVariable long id,@RequestBody EmployeeDto employeeDetails) {		
		return ResponseEntity.ok(employeeService.updateEmplyeeById(id, employeeDetails));
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id){		
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}
}
