package com.department.cntroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.dto.EmployeeDto;
import com.department.dto.ResponseDto;
import com.department.service.EmployeeService;
import com.department.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeCtrl {

	private final EmployeeService employeeService;

	public EmployeeCtrl(EmployeeServiceImpl employeeServiceImpl) {
		this.employeeService = employeeServiceImpl;
	}

	@GetMapping("/get-all-employee")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getEmployeeList());
	}

	@GetMapping("/get-employee/{depId}")
	public ResponseEntity<List<EmployeeDto>> getEmployeeByDepartment(@PathVariable("depId") String departmentId) {
		return ResponseEntity.ok(employeeService.getEmployeeByDepartment(departmentId));
	}

	@GetMapping("/{empId}")
	public ResponseEntity<ResponseDto> getEmployee(@PathVariable("empId") String employeeId) {
		return ResponseEntity.ok(new ResponseDto(1000, "Employee Found", employeeService.getEmployee(employeeId)));
	}

	@PostMapping(value = "/add-new-employee")
	public ResponseEntity<ResponseDto> getEmployeeByDepartment(@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok(employeeService.addNewEmployeeInDepartment(employeeDto));
	}

	@DeleteMapping(value = "/delete-employee/{empId}")
	public ResponseEntity<ResponseDto> deleteEmployee(@PathVariable("empId") String employeeId) {
		return ResponseEntity.ok(employeeService.deleteEmployeeInDepartment(employeeId));
	}
}
