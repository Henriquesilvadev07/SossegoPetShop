package com.sossegopet.SossegoPetShop.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoudException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoudException e) {
        StandardError err = new StandardError(404, e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(404).body(err);
    }
}
