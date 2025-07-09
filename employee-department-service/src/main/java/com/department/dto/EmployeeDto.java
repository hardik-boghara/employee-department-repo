package com.department.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 6733546560667647649L;

	private String id;
	private String name;
	private String email;
	private String position;
	private Long salary;
	@JsonBackReference
	private DepartmentDto department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	public EmployeeDto() {
	}

	public EmployeeDto(String dName, String name, String position, String email, Long salary) {
		super();
		this.department = new DepartmentDto();
		this.department.setName(dName); 
		this.name = name;
		this.email = email;
		this.position = position;
		this.salary = salary;
	}
}