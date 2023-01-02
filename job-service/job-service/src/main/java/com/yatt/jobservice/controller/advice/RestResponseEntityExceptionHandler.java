package com.yatt.jobservice.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.yatt.jobservice.controller.exceptions.JobExitsExceptions;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler(value = { JobExitsExceptions.class })
	protected ResponseEntity<Object> jobExitsExceptions(JobExitsExceptions ex, WebRequest request) {
		String message = ex.getMessage();
		return new ResponseEntity<>(message, HttpStatus.CONFLICT);
	}
}
