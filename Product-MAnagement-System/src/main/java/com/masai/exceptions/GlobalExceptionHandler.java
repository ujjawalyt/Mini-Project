package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> myMNVHandler(MethodArgumentNotValidException me){
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<MyErrorDetail> productNotFoundHandler(ProductNotFound pn, WebRequest wr){
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pn.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<MyErrorDetail> invalidIdHandler(InvalidId ivi, WebRequest wr){
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ivi.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetail> loginExceptionHandler(LoginException ivi, WebRequest wr){
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ivi.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
		
	
	
}
