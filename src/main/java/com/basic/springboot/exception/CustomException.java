package com.basic.springboot.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5724575018718472047L;
	
	String name;
	int status;
	String reasonPharse;
	
	public CustomException(HttpStatus httpStatus) {
		this.name = httpStatus.name();
		this.status = httpStatus.value();
		this.reasonPharse = httpStatus.getReasonPhrase();
	}
}
