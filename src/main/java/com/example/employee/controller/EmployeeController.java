package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		System.out.printf("Exiting getEmployeeDetails with employeeDTO: {}", employeeDTO);
		
		return employeeDTO;
	}

	@PostMapping("addEmployeeDetails")
	public EmployeeDTO addEmployeeDetails(@RequestBody EmployeeDTO employeeDTO) {

		System.out.printf("Entering addEmployeeDetails with employeeDTO: {}", employeeDTO);
		
		EmployeeDTO employeeDTOResponse = new EmployeeDTO();
		EmployeeVO employeeVO = new EmployeeVO();

		BeanUtils.copyProperties(employeeDTO, employeeVO);

		EmployeeVO employeeVOResponse = employeeService.addEmployeeDetails(employeeVO);

		BeanUtils.copyProperties(employeeVOResponse, employeeDTOResponse);

		System.out.printf("Exiting addEmployeeDetails with employeeDTOResponse: {}", employeeDTOResponse);
		
		return employeeDTOResponse;
	}

	@PutMapping("updateEmployeeDetails/id/{id}")
	public EmployeeDTO updateEmployeeDetails(@PathVariable(value = "id") long id, 
										@RequestBody EmployeeDTO employeeDTO) throws Exception {

		EmployeeDTO employeeDTOResponse = new EmployeeDTO();
		EmployeeVO employeeVO = new EmployeeVO();

		BeanUtils.copyProperties(employeeDTO, employeeVO);
		
		EmployeeVO employeeVOResponse = employeeService.updateEmployeeDetails(id, employeeVO);
		
		BeanUtils.copyProperties(employeeVOResponse, employeeDTOResponse);
		
		return employeeDTOResponse;
	}

	@DeleteMapping("deleteEmployeeDetails/id/{id}")
	public String deleteEmployeeDetails(@PathVariable(value = "id") long id) throws Exception {

		employeeService.deleteEmployeeDetails(id);
		
		String response = "Deleted successfully!";
		
		return response;
	}

}
