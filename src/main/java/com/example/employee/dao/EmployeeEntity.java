package com.example.employee.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	@Column(name = "empId")
	private long id;
	
	@Column(nullable = false, name = "firstName", length = 30)
	private String firstName;
	
	@Column(name = "lastName", length = 30)
	private String lastName;

	@Column(name = "deptName", length = 30)
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

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
