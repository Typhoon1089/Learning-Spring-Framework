package com.typhoon.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import com.typhoon.rest.webservices.restfulwebservices.user.UserNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController 
public class CustomizedReponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptionsEntity(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = 
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = 
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), 
                "Validation failed", //"ex.getMessage()", 
                ex.getBindingResult().toString());
        // return handleExceptionInternal(ex, null, headers, status, request);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
