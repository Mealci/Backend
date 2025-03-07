package com.mealci.api.configuration.handlers;

import com.mealci.core.exceptions.ConflictException;
import com.mealci.core.exceptions.NotFoundException;
import com.mealci.core.exceptions.UnauthorizedException;
import com.mealci.core.exceptions.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorResponse> handleException(UnprocessableEntityException exception) {
        var errorResponse = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exception) {
        var errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handleException(UnauthorizedException exception) {
        var errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.toString(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorResponse> handleException(ConflictException exception) {
        var errorResponse = new ErrorResponse(HttpStatus.CONFLICT.toString(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
