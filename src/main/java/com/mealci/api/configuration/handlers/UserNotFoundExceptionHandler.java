package com.mealci.api.configuration.handlers;

import com.mealci.core.exceptions.DalException;
import com.mealci.core.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(DalException.class)
    public ResponseEntity<String> handleDalException(UserNotFoundException exception) {
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}
