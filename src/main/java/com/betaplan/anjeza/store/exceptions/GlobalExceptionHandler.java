package com.betaplan.anjeza.store.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CategoryFoundException.class, })
    public void handleCategoryFoundException(CategoryFoundException categoryFoundException){
//        if()
    }
}
