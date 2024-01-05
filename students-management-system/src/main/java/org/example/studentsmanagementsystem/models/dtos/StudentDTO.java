package org.example.studentsmanagementsystem.models.dtos;

import lombok.Data;

@Data
public class StudentDTO {

    private String lastName;
    private String firstName;
    private int age;

    private BadgeDTO badge;
}
