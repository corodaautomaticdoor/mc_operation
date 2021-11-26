package com.coroda.mcoperation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class CustomizeExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomizeErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exc) {
		CustomizeErrorDetails resourceNotFound = new CustomizeErrorDetails(new Date(), exc.getMessage());
		return new ResponseEntity<CustomizeErrorDetails>(resourceNotFound, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataException.class)
	public ResponseEntity<CustomizeErrorDetails> handlDataFormatException(DataException exc){
		CustomizeErrorDetails dataErrorDetail = new CustomizeErrorDetails(new Date(), exc.getMessage());
		return new ResponseEntity<CustomizeErrorDetails> (dataErrorDetail, HttpStatus.BAD_REQUEST);
	}
}
