package com.department.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.department.dto.ResponseDto;

@RestControllerAdvice
public class AdviceController {

	@ExceptionHandler(NoDataFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseDto handleNoDataFoundException(NoDataFoundException exception) {
		return new ResponseDto(HttpStatus.NO_CONTENT.value(), exception.getMessage());
	}

}
