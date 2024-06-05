package com.schedule.demo.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiError {
	
	/*
	 * Classe responsavel por dar um retorno pro usuario
	 */
	
	private int statusCode;
	private String message;
	private LocalDateTime date;
	
	public ApiError(int statusCode, String message, LocalDateTime localDateTime) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.date = localDateTime;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
	
}
