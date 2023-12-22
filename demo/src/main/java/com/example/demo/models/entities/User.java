package com.example.demo.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

// an @Entity annotated class is meant to map the table called 'users' from the database
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // we can also have validations on the fields,
    // so we have full control on the input at any layer.
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    private String name;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    private String country;

    @NotNull
    @Pattern(regexp = ".+@.+\\..+")
    private String email;

    @NotNull
    @Range(min = 18, max = 75)
    private Integer age;
}
