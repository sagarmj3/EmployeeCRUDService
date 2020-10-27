package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.service.EmployeeService;
import com.example.employee.vo.EmployeeVO;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("getEmployeeDetails")
	public List<EmployeeDTO> getEmployeeDetails() {

		System.out.printf("Entering getEmployeeDetails");
		
		List<EmployeeDTO> employeeDTO = new ArrayList<EmployeeDTO>();

		employeeDTO = employeeService.getEmployeeDetails();
		
		System.out.printf("Exiting getEmployeeDetails");
		
		return employeeDTO;
	}

	
	@PostMapping("addEmployeeDetails")
	public EmployeeDTO addEmployeeDetails(@RequestBody EmployeeDTO employeeDTO) {

		System.out.printf("Entering addEmployeeDetails");
		
		EmployeeDTO employeeDTOResponse = new EmployeeDTO();
		EmployeeVO employeeVO = new EmployeeVO();

		BeanUtils.copyProperties(employeeDTO, employeeVO);

		EmployeeVO employeeVOResponse = employeeService.addEmployeeDetails(employeeVO);

		BeanUtils.copyProperties(employeeVOResponse, employeeDTOResponse);

		System.out.printf("Exiting addEmployeeDetails");
		
		return employeeDTOResponse;
	}

	@PutMapping("updateEmployeeDetails/id/{id}")
	public EmployeeDTO updateEmployeeDetails(@PathVariable(value = "id") long id, 
										@RequestBody EmployeeDTO employeeDTO) throws Exception {

		System.out.printf("Entering updateEmployeeDetails");
		
		EmployeeDTO employeeDTOResponse = new EmployeeDTO();
		EmployeeVO employeeVO = new EmployeeVO();

		BeanUtils.copyProperties(employeeDTO, employeeVO);
		
		EmployeeVO employeeVOResponse = employeeService.updateEmployeeDetails(id, employeeVO);
		
		BeanUtils.copyProperties(employeeVOResponse, employeeDTOResponse);
		
		System.out.printf("Exiting updateEmployeeDetails");
		
		return employeeDTOResponse;
	}

	@DeleteMapping("deleteEmployeeDetails/id/{id}")
	public String deleteEmployeeDetails(@PathVariable(value = "id") long id) throws Exception {

		System.out.printf("Entering deleteEmployeeDetails");
		
		employeeService.deleteEmployeeDetails(id);
		
		String response = "Deleted successfully!";
		
		System.out.printf("Exiting deleteEmployeeDetails");
		
		return response;
	}

}
