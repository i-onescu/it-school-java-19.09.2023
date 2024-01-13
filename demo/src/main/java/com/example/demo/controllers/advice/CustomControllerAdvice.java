package com.example.demo.controllers.advice;

import com.example.demo.controllers.util.ResponseBuilderHelper;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.models.dtos.ResponsePayload;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;


// The class annotated with @ControllerAdvice works as try catch block
// over the classes annotated with @Controller
// so if a method within the @Controller class throws an exception it can be caught here
@ControllerAdvice
public class CustomControllerAdvice {

    // the method must be annotated @ExceptionHandler which accepts as parameter
    // a list of exceptions, or only one exception.
    @ExceptionHandler({UserNotFoundException.class, IOException.class})
    // we can have multiple parameters in the method, note that the caught exceptions are
    // a checked exception and an unchecked exception, thus the parameter must be Exception e in order to catch the IOException too.
    // Usually we have as params the request and the exception
    public ResponseEntity<ResponsePayload> handleUserNotFound(Exception e, HttpServletRequest request) {
        if (e instanceof UserNotFoundException exception) {
            return ResponseBuilderHelper.buildResponsePayload(String.format("User with id %d not found!",
                            exception.getUserId()),
                    HttpStatus.NOT_FOUND);
        } else {
            return ResponseBuilderHelper.buildResponsePayload(String.format("User with id %s not found!", request.getServletPath().split("/")[2]),
                    HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponsePayload> handleValidationException(HttpServletRequest request) {
        return ResponseBuilderHelper.buildResponsePayload("Wrong request!",
                HttpStatus.BAD_REQUEST);
    }
}
