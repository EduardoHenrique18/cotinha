package com.cotinha.cotinha.exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Handler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CotaNotFound.class)
    public ResponseEntity<StandardError> notFound(CotaNotFound err, HttpServletRequest request ){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), err.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ExistingEmail.class)
    public ResponseEntity<StandardError> existing(ExistingEmail err, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), err.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
