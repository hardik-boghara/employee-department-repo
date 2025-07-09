package com.department.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class DepartmentDto implements Serializable {

	private static final long serialVersionUID = -269650800222290445L;

	private String id;
	private String name;
	private String location;

	@JsonManagedReference
	private List<EmployeeDto> employees;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}

	
	public DepartmentDto() {
	}

	public DepartmentDto(String id) {
		super();
		this.id = id;
	}

}