package com.thupq.coffee.configurations.security;

import com.thupq.coffee.exceptions.Error;
import com.thupq.coffee.exceptions.ErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { ErrorException.class })
    @ResponseBody
    public ResponseEntity<Error> handleException(ErrorException ex) {
        List<String> messages = Arrays.asList(ex.getMessage());
        return ResponseEntity
                .status(ex.getStatus())
                .body(Error.builder().messages(messages).build());
    }
}