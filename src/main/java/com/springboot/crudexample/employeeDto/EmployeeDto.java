package com.springboot.crudexample.employeeDto;

public class EmployeeDto {
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	public EmployeeDto() {
		
	}
	public EmployeeDto(long id, String firstName, String lastName, String emailId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fisrtName) {
		this.firstName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", fisrtName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
}
