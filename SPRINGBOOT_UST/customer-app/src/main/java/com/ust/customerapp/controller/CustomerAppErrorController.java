package com.ust.customerapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.customerapp.dto.ErrorResponse;
import com.ust.customerapp.exception.CustomerNotFoundException;
import com.ust.customerapp.exception.DuplicateCustomerException;

@RestControllerAdvice
public class CustomerAppErrorController {
//	@ResponseStatus(code=HttpStatus.CONFLICT)
//	@ExceptionHandler(DuplicateCustomerException.class)
//	public String handleCustomerNotFoundError(DuplicateCustomerException e) {
//		return e.getMessage();
//	}
//	
//	@ResponseStatus(code=HttpStatus.NOT_FOUND)

//	public String handleCustomerNotFoundError(CustomerNotFoundException ex) {
//		return ex.getMessage();
//	}
//	
	
	
	
	
////	@ResponseStatus(code=HttpStatus.NOT_FOUND)
////    @ExceptionHandler(CustomerNotFoundException.class)
////    public ResponseEntity<ErrorResponse> hanldeCustomerNotFoundException(CustomerNotFoundException e, HttpServletRequest request) {
////        HttpStatus status=HttpStatus.NOT_FOUND;
////        ErrorResponse body =new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), e.getMessage(),request.getRequestURI());
////        return ResponseEntity.status(status).body(body);
////
////	}	
////	@ResponseStatus(code=HttpStatus.CONFLICT)
////    @ExceptionHandler(DuplicateCustomerException.class)
////    public ResponseEntity<ErrorResponse> handleDuplicateCustomerException(DuplicateCustomerException ex, HttpServletRequest request) {
////        HttpStatus status=HttpStatus.CONFLICT;
////        ErrorResponse body=new ErrorResponse(LocalDateTime.now(),status.value()
////                ,status.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
////9
////            return ResponseEntity.status(status).body(body);
////    }
//

	@ExceptionHandler(DuplicateCustomerException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handlecustomernotfoundexception(DuplicateCustomerException ex,HttpServletRequest request) {
	var status=HttpStatus.INTERNAL_SERVER_ERROR;
	var StatusValue=status.value();
	var error=status.name();
	var timestamp=LocalDateTime.now();
	var path=request.getRequestURI();
	var message=ex.getMessage();
	return new ErrorResponse(timestamp, StatusValue, error, message, path);}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorResponse handlecustomernotfoundexception(CustomerNotFoundException ex,HttpServletRequest request) {
	var status=HttpStatus.NOT_FOUND;
	var StatusValue=status.value();
	var error=status.name();
	var timestamp=LocalDateTime.now();
	var path=request.getRequestURI();
	var message=ex.getMessage();
	return new ErrorResponse(timestamp, StatusValue, error, message, path);
}}
