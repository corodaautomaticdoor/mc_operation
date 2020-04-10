package com.coroda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomizeErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exc, WebRequest req) {

        CustomizeErrorDetails resourceNotFound = new CustomizeErrorDetails(new Date(), exc.getMessage(), req.getDescription(false));

        return new ResponseEntity<CustomizeErrorDetails>(resourceNotFound, HttpStatus.NOT_FOUND);
    }

}
