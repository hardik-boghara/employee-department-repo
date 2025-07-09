package com.department.cntroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.dto.DepartmentDto;
import com.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentCtrl {

	private final DepartmentService departmentService;

	public DepartmentCtrl(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/get-all-department")
	public ResponseEntity<List<DepartmentDto>> getAllEmployees() {
		return ResponseEntity.ok(departmentService.getDepartmentList());
	}

	@GetMapping("/get-employee/{depId}")
	public ResponseEntity<List<DepartmentDto>> getEmployeeByDepartment(@PathVariable String depId) {
		return ResponseEntity.ok(departmentService.getDepartmentList());
	}
}
