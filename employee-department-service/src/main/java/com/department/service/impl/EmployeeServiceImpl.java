package com.department.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.department.advice.NoDataFoundException;
import com.department.domain.Employee;
import com.department.dto.DepartmentDto;
import com.department.dto.EmployeeDto;
import com.department.dto.ResponseDto;
import com.department.repository.EmployeeRepository;
import com.department.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepo;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<EmployeeDto> getEmployeeList() {
		List<Employee> allEmployees = employeeRepo.findAll();

		if (allEmployees.isEmpty()) {
			throw new NoDataFoundException("Employee data is Not available");
		}

		List<EmployeeDto> employeesList = new ArrayList<>(allEmployees.size());
		ModelMapper mapper = new ModelMapper();

		allEmployees.forEach(employee -> {
			EmployeeDto empDto = new EmployeeDto();
			mapper.map(employee, empDto);
			employeesList.add(empDto);
		});

		return employeesList;
	}

	@Override
	public List<EmployeeDto> getEmployeeByDepartment(String departmentId) {
		List<Employee> allEmployees = employeeRepo.findEmployeeByDepartmentId(departmentId);

		if (allEmployees.isEmpty()) {
			throw new NoDataFoundException("Employee data is Not available");
		}

		List<EmployeeDto> employeesList = new ArrayList<>(allEmployees.size());
		ModelMapper mapper = new ModelMapper();

		allEmployees.forEach(employee -> {
			EmployeeDto empDto = new EmployeeDto();
			mapper.map(employee, empDto);
			employeesList.add(empDto);
		});

		return employeesList;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ResponseDto addNewEmployeeInDepartment(EmployeeDto employeeDto) {

		if(employeeDto.getId().isBlank()) {
			ModelMapper mapper = new ModelMapper();
			Employee employee = mapper.map(employeeDto, Employee.class);
			employeeRepo.save(employee);
			if (!employee.getId().isBlank()) {
				return new ResponseDto(1000, "New Employee added in department " + employeeDto.getDepartment().getId());
			}
			return new ResponseDto(501, "Error in new Employee addition");
		} else {
			Employee employee = employeeRepo.findById(employeeDto.getId()).orElseThrow(() -> new NoDataFoundException("Employee Not Found"));
			
			employee.setName(employeeDto.getName());
			employee.setEmail(employeeDto.getEmail());
			employee.setSalary(employeeDto.getSalary());
			employee.setPosition(employeeDto.getPosition());
			employeeRepo.save(employee);
			
			if (!employee.getId().isBlank()) {
				return new ResponseDto(1000, "Employee Updated");
			}
			return new ResponseDto(501, "Error in new Employee Updation");

		}
	}

	@Override
	@Transactional
	public ResponseDto deleteEmployeeInDepartment(String employeeId) {
		employeeRepo.deleteById(employeeId);
		return new ResponseDto(1000, "Employee Deleted");
	}

	@Override
	public List<EmployeeDto> getEmployeeReportData() {
	    List<Employee> employees = employeeRepo.findAll();

	    return employees.stream()
	        .map(emp -> new EmployeeDto(
	            emp.getDepartment().getName(),
	            emp.getName(),
	            emp.getPosition(),
	            emp.getEmail(),
	            emp.getSalary()))
	        .toList();
	}

	@Override
	public EmployeeDto getEmployee(String employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new NoDataFoundException("Employee Not Found"));
		ModelMapper mapper = new ModelMapper();
		EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}

}
