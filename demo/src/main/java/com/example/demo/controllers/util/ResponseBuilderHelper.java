package com.example.demo.controllers.util;

import com.example.demo.models.dtos.ResponsePayload;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// This is a utility class, not meant to be instantiated
// which provides a method to create a uniformized response payload.
@UtilityClass
public final class ResponseBuilderHelper {

    public static ResponseEntity<ResponsePayload> buildResponsePayload(Object response, HttpStatus status) {
        return new ResponseEntity<>(ResponsePayload.builder()
                .response(response)
                .statusCode(status.name())
                .build(), status);
    }
}
