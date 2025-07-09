package com.department.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.department.advice.NoDataFoundException;
import com.department.domain.Department;
import com.department.dto.DepartmentDto;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepo;

	public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
		this.departmentRepo = departmentRepo;
	}

	@Override
	@Transactional
	public List<DepartmentDto> getDepartmentList() {
		List<Department> allDepartments = departmentRepo.findAll();

		if (allDepartments.isEmpty()) {
			throw new NoDataFoundException("Department data is Not available");
		}

		List<DepartmentDto> departmentList = new ArrayList<>(allDepartments.size());
		ModelMapper mapper = new ModelMapper();
		
		allDepartments.forEach(department -> {
			DepartmentDto departmentDto = new DepartmentDto();
			mapper.map(department, departmentDto);
			departmentList.add(departmentDto);
		});

		return departmentList;
	}
}
