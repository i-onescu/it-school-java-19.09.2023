package com.example.demo.models.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

// a regular record with validations applied on it.
// the fields are marked nullable to allow the PutMapping method.
@Builder
public record UserDTO(@Nullable @Pattern(regexp = "[a-zA-Z]+") String name,
                      @Nullable @Pattern(regexp = "[a-zA-Z]+") String country,
                      @Nullable @Pattern(regexp = ".+@.+\\..+") String email,
                      @Nullable @Range(min = 18, max = 75) Integer age) { }
