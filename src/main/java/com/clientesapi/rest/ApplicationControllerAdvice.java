package com.clientesapi.rest;

import java.util.stream.Collectors;

import com.clientesapi.rest.exception.ApiErrors;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors( MethodArgumentNotValidException ex ){
        BindingResult bindResult = ex.getBindingResult();
          	 List<String> messages = bindResult.getAllErrors() 
            .stream() 
            .map( objectError -> objectError.getDefaultMessage() ) 
            .collect(Collectors.toList());

            return new ApiErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){
      String mensagemErro = ex.getMessage();
      HttpStatus codigoStatus = ex.getStatus();
      ApiErrors apiErrors = new ApiErrors(mensagemErro);
      return new ResponseEntity(apiErrors, codigoStatus);
  } 
    
}
