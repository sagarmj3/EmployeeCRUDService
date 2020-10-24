package com.example.employee.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long>
{
	
	List<EmployeeEntity> findAll();
	
	EmployeeEntity findById(long id);
	
}
