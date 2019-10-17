package com.stackroute.userservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<String> globalExceptionHandler1(){
        return new ResponseEntity<String>("User with given parameters does not exist", HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<String> globalExceptioHandler2(){
        return new ResponseEntity<String>("User with given parameters already exists",HttpStatus.CONFLICT);
    }
}
