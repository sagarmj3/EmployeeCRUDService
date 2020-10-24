package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.vo.EmployeeVO;

@Component
public interface EmployeeService {

	public EmployeeVO addEmployeeDetails(EmployeeVO employeeVO);

	public List<EmployeeDTO> getEmployeeDetails();

	public EmployeeVO updateEmployeeDetails(long id, EmployeeVO employeeVO) throws Exception;

	public void deleteEmployeeDetails(long id) throws Exception;

	
}
