package com.codegym.demo_spring_data_jpa.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFoundUrl(){
        return "not-found";
    }
}
