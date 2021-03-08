package com.maarouf.qaApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(QTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String qTypeNotFoundHandler(QTypeNotFoundException ex){
        return ex.getMessage();
    }
}
