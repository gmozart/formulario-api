package com.demo.formularioapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FmlNotFoundException extends RuntimeException{
    public  FmlNotFoundException(){
        super("Resource not found!");
    }
    public FmlNotFoundException(String exception){
        super(exception);
    }
}
