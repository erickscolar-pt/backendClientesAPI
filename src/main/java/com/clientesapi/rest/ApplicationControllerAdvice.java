package com.clientesapi.rest;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import antlr.collections.List;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleValidationErrors( MethodArgumentNotValidException ex ){
        BindingResult bindResult = ex.getBindingResult();
          List<String> messages = bindResult.getAllErrors()
            .stream()
            .map( objectError -> objectError.getDefaultMessage() )
            .collect(Collectors.toList());
    }
    
}
