package com.department.service;

import java.util.List;

import com.department.dto.EmployeeDto;

public interface ReportService {

	public byte[] exportEmployeeDepartmentReport(List<EmployeeDto> data) throws Exception;
}
