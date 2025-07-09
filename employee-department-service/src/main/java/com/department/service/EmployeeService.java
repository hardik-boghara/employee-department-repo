package com.department.service;

import java.util.List;

import com.department.dto.EmployeeDto;
import com.department.dto.ResponseDto;

public interface EmployeeService {

	List<EmployeeDto> getEmployeeList();

	List<EmployeeDto> getEmployeeByDepartment(String departmentId);

	EmployeeDto getEmployee(String employeeId);

	ResponseDto addNewEmployeeInDepartment(EmployeeDto employeeDto);

	ResponseDto deleteEmployeeInDepartment(String employeeId);

	List<EmployeeDto> getEmployeeReportData();

}
