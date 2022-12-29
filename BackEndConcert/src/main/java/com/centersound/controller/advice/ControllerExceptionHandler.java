package com.centersound.controller.advice;

import com.centersound.exceptions.CustomerWithEmailAlreadyExists;
import com.centersound.exceptions.ToManyTicketsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ToManyTicketsException.class)
    public ResponseEntity<String> toManyTickets(ToManyTicketsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerWithEmailAlreadyExists.class)
    public ResponseEntity<String> customerWithMailAlreadyExists(CustomerWithEmailAlreadyExists e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> dataIntegrityException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();

        e.getAllErrors().stream().forEach(exception -> {
            sb.append(exception.getDefaultMessage() + "\n");
        });

        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);

    }
}
