package com.sb.app.exception.Advices;

import com.sb.app.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<Object> exception(OrderNotFoundException exception) {
        return new ResponseEntity<>("order not found", HttpStatus.NOT_FOUND);
    }
}
