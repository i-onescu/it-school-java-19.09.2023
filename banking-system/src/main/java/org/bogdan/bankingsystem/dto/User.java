package org.bogdan.bankingsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

// Used Lombok annotations to avoid boilerplate code
// @Data provides getters, setters, all required arguments constructor, toString method, equals and hashcode methods
@Data
// This annotation provides a ctor with all fields
@AllArgsConstructor
// This annotation provides the ctor without any param
@NoArgsConstructor
public class User {
    private int id;

    // we can add validations on the fields
    @NotBlank
    @Size(min = 3, max = 50)
    // this uses Regular Expression (RegEx) to ensure that the name contains only letters
    @Pattern(regexp = "[a-zA-Z]")
    private String name;

    @NotNull
    // These will require the age to be between 18 and 75
    @Min(18)
    @Max(75)
    // Equivalent
    // @Range(min = 18, max = 75)
    private int age;

    // you can send data from JSON as string if you follow the default template
    // e.g. 2023-10-10
    private LocalDate joinDate;
}
