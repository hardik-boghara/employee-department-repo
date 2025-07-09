package com.department.advice;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = -5597982380064043759L;
	
	public NoDataFoundException(String message) {
		super(message);
	}
}
