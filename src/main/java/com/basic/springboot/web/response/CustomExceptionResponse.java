package com.basic.springboot.web.response;

import com.basic.springboot.exception.CustomException;

import lombok.Data;

@Data
public class CustomExceptionResponse {
	String message;
	
	static public CustomExceptionResponse valueOf(CustomException e) {
		CustomExceptionResponse response = new CustomExceptionResponse();
		response.setMessage(e.getMessage());
		
		return response;
	}
}
