package com.example.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeEntity;
import com.example.employee.dao.EmployeeRepository;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.service.EmployeeService;
import com.example.employee.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeVO addEmployeeDetails(EmployeeVO employeeVO) {
		
		EmployeeEntity inEmployeeEntity = new EmployeeEntity();
		EmployeeVO employee = new EmployeeVO();
		
		BeanUtils.copyProperties(employeeVO, inEmployeeEntity);
		
		EmployeeEntity outEmployeeEntity = employeeRepository.save(inEmployeeEntity);
		
		BeanUtils.copyProperties(outEmployeeEntity, employee);
		
		return employee;
	}

	@Override
	public List<EmployeeDTO> getEmployeeDetails() {

		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		List<EmployeeEntity> employeeEntity = new ArrayList<>();;
 		
		employeeEntity = employeeRepository.findAll();
		
		mapResponse(employeeDTOs, employeeDTO, employeeEntity);
		
		return employeeDTOs;
	}

	@Override
	public EmployeeVO updateEmployeeDetails(long id, EmployeeVO employeeVO) throws Exception {

		EmployeeVO employeeResponse = new EmployeeVO();
		
		EmployeeEntity inEmployeeEntity = employeeRepository.findById(id);
		
		if (null != inEmployeeEntity) {
			
			employeeVO.setId(id);
			BeanUtils.copyProperties(employeeVO, inEmployeeEntity);

			EmployeeEntity outEmployeeEntity = employeeRepository.save(inEmployeeEntity);

			BeanUtils.copyProperties(outEmployeeEntity, employeeResponse);

		} else {
			throw new Exception("Employee details not found");
		}
		
		return employeeResponse;
	}
	
	@Override
	public void deleteEmployeeDetails(long id) throws Exception {

		if(employeeRepository.findById(id) == null) {
			throw new Exception("Employee details not found");
		}
		
		employeeRepository.deleteById(id);
		
	}
	
	private void mapResponse(List<EmployeeDTO> employeeDTOs, EmployeeDTO employeeDTO, List<EmployeeEntity> employeeEntity) {
		if(null != employeeEntity) {
			for(EmployeeEntity employee : employeeEntity) {
				employeeDTO.setId(employee.getId());
				employeeDTO.setFirstName(employee.getFirstName());
				employeeDTO.setLastName(employee.getLastName());
				employeeDTO.setDeptName(employee.getDeptName());
				
				employeeDTOs.add(employeeDTO);
			}
		}
	}

}
