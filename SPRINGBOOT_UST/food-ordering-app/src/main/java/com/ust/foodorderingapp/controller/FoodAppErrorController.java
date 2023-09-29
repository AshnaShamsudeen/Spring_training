package com.ust.foodorderingapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.foodorderingapp.dto.ErrorResponse;
import com.ust.foodorderingapp.exception.InvalidCategoryException;
import com.ust.foodorderingapp.exception.ItemNotFoundException;

@RestControllerAdvice
public class FoodAppErrorController {	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleItemNotFoundException(ItemNotFoundException e,HttpServletRequest request){
		HttpStatus status=HttpStatus.NOT_FOUND;
		ErrorResponse body=new ErrorResponse(LocalDateTime.now(),status.value(),status.getReasonPhrase(),e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(body);
	}
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidCategoryException.class)
	public ResponseEntity<ErrorResponse>handleInvalidCategoryException(InvalidCategoryException e,HttpServletRequest request){
		HttpStatus status=HttpStatus.NOT_FOUND;
		ErrorResponse body=new ErrorResponse(LocalDateTime.now(),status.value(),status.getReasonPhrase(),e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(body);
	}
	
	
	
	
	

}
