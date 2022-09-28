package com.springboot.crudexample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudexample.employeeDto.EmployeeDto;
import com.springboot.crudexample.exception.ResourceNotFounfException;
import com.springboot.crudexample.model.Employee;
import com.springboot.crudexample.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<EmployeeDto> fildAllEmployee() {
		List<Employee> employee=employeeRepository.findAll();
		List<EmployeeDto> employeeDto= employee.stream().map(data->modelMapper.map(data, EmployeeDto.class)).collect(Collectors.toList());
		return  employeeDto;
	}
	@Override
	public EmployeeDto getEmplyeeById(long id) {
		Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFounfException("Employee not exist with id :"+id));
		if(employee!=null) {
			return modelMapper.map(employee, EmployeeDto.class);
		}
		return null;		
	}
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=modelMapper.map(employeeDto, Employee.class);		
		return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
	}
	@Override
	public EmployeeDto updateEmplyeeById(long id,EmployeeDto employeeDetails) {
		Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFounfException("Employee not exist with id :"+id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		//Employee updateEmployee =employeeRepository.save(employee);
		return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
	}
	@Override
	public Map<String,Boolean> deleteEmployee(long id){
		Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFounfException("Employee not exist with id :"+id));
		employeeRepository.delete(employee);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
