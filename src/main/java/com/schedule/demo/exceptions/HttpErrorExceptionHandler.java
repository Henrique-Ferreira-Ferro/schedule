package com.schedule.demo.exceptions;

import java.time.LocalDateTime;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpErrorExceptionHandler {
	
	/*
	 * Responsavel pelo controle das exceções
	 * 
	 */
	
	
	private ResponseEntity<ApiError> buildErrorResponse(HttpStatus status, String message){
		var error = new ApiError(status.value(), message, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}
	
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiError> badRequest(BadRequestException exception){
		return buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ApiError> notFound(ObjectNotFoundException exception){	
		return buildErrorResponse(HttpStatus.NOT_FOUND, "Não foi possivel encontrar "+ exception.getEntityName());
	}
	
	
}
