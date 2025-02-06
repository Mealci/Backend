package com.mealci.api.configuration.handlers;

import com.mealci.core.exceptions.DalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DalExceptionHandler {

    @ExceptionHandler(DalException.class)
    public ResponseEntity<String> handleDalException(DalException exception) {
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}
