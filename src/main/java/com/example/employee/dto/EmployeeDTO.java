package com.example.employee.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
	
	private static final long serialVersionUID = 6165122448759293165L;
	private long id;
	private String firstName;
	private String lastName;
	private String deptName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", deptName="
				+ deptName + "]";
	}
		
}
