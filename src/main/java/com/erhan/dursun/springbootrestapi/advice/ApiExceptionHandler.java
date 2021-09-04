package com.erhan.dursun.springbootrestapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalAccessError.class)
    public final ResponseEntity<ExcetionResponse>   illegalExcetion(Exception exception, WebRequest request){
        ExcetionResponse excetionResponse= new ExcetionResponse(LocalDate.now(),"10000",exception.getMessage());
        return  new ResponseEntity<ExcetionResponse>(excetionResponse, HttpStatus.EXPECTATION_FAILED);

    }

    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<ExcetionResponse>   userNotFound(Exception exception, WebRequest request){
        ExcetionResponse excetionResponse= new ExcetionResponse(LocalDate.now(),"2000",exception.getMessage());
        return  new ResponseEntity<ExcetionResponse>(excetionResponse, HttpStatus.EXPECTATION_FAILED);

    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcetionResponse>   exception(Exception exception, WebRequest request){
        ExcetionResponse excetionResponse= new ExcetionResponse(LocalDate.now(),"5000",exception.getMessage());
        return  new ResponseEntity<ExcetionResponse>(excetionResponse, HttpStatus.EXPECTATION_FAILED);

    }

}
