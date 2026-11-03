package com.example.AuthorMS.exception_handling;

import com.example.AuthorMS.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<?> handleAuthorNotFoundException(AuthorNotFoundException authorNotFoundException)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setTime(LocalDateTime.now());
        errorResponse.setMessage(authorNotFoundException.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
