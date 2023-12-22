package com.example.demo.models.dtos;

import lombok.Builder;

// regular record containing any kind of response, from string to dtos
// and the corresponding status code.
@Builder
public record ResponsePayload(Object response, String statusCode) { }
