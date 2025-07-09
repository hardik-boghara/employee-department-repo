package com.department.cntroller;

import java.util.List;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.dto.EmployeeDto;
import com.department.service.EmployeeService;
import com.department.service.ReportService;
import com.department.service.impl.ReportServiceImpl;

@RestController
@RequestMapping("/report")
public class ReportController {

	private final ReportService reportService;
	private final EmployeeService employeeService;

	public ReportController(ReportServiceImpl reportService, EmployeeService employeeService) {
		this.reportService = reportService;
		this.employeeService = employeeService;
	}

	@GetMapping("/employee-pdf")
	public ResponseEntity<byte[]> generateEmployeeReport() throws Exception {
		List<EmployeeDto> reportData = employeeService.getEmployeeReportData(); // You write this method

		byte[] pdf = reportService.exportEmployeeDepartmentReport(reportData);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDisposition(ContentDisposition.attachment().filename("employee_report.pdf").build());

		return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
	}
}
