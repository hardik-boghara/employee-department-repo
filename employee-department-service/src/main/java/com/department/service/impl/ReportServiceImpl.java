package com.department.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.department.dto.EmployeeDto;
import com.department.service.ReportService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportServiceImpl implements ReportService {

	@Override
	public byte[] exportEmployeeDepartmentReport(List<EmployeeDto> data) throws Exception {
		InputStream reportStream = getClass().getResourceAsStream("/reports/employee_department_report.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Hardik");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
}
