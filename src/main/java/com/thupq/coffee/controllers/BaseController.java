package com.thupq.coffee.controllers;

import com.thupq.coffee.common.MessageUtils;
import com.thupq.coffee.exceptions.Error;
import com.thupq.coffee.exceptions.Error.CodeEnum;
import com.thupq.coffee.exceptions.ErrorException;
import com.thupq.coffee.exceptions.ExceptionUtils;
import com.thupq.coffee.exceptions.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
public class BaseController implements ErrorController {

    @ExceptionHandler({ErrorException.class})
    public ResponseEntity<Error> handleErrorException(ErrorException exception) {
        log.warn("Caught a error exception request {}", exception.getError().getCode());
        log.debug("Caught a error exception request", exception);
        return new ResponseEntity<>(
                exception.getError(),
                exception.getStatus()
        );
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("Caught a unhandled request", exception);
        String message = "Invalid request";
        try {
            message = MessageUtils.getMessage(exception.getBindingResult()
                    .getAllErrors().get(0).getDefaultMessage());
        } catch (Exception ignore) {}
        return new ResponseEntity<>(
                Error.builder()
                        .messages(Arrays.asList(message))
                        .code(CodeEnum.BAD_REQUEST)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleException(Exception exception) {
        log.error("Caught a unhandled request", exception);
        return new ResponseEntity<>(
                Error.builder()
                        .messages(Collections.singletonList("Unexpected error"))
                        .code(CodeEnum.UNEXPECTED_ERROR)
                        .data(ExceptionUtils.stackTraceToListMessages(exception.getStackTrace()))
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler({ValidateException.class})
    public ResponseEntity<Error> handleValidateException(ValidateException exception) {
        log.error("Caught a unhandled request", exception);
        return new ResponseEntity<>(
                Error.builder()
                        .messages(Collections.singletonList(exception.getMessage()))
                        .code(CodeEnum.BAD_REQUEST)
                        .data(exception.getError())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

}
