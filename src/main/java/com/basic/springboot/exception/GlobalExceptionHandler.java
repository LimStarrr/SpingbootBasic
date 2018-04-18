package com.basic.springboot.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.basic.springboot.web.response.CustomExceptionResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({CustomException.class})
	@ResponseBody
	public CustomExceptionResponse handleCustomBadRequestException(HttpServletResponse response, CustomException e) {
		log.error(e.getName(), e);
		
		response.setStatus(e.getStatus());
		
		return CustomExceptionResponse.valueOf(e);
	}
}
