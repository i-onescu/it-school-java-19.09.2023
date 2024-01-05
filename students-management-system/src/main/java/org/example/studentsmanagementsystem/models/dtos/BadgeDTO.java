package org.example.studentsmanagementsystem.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BadgeDTO {

    private LocalDate issuedAt;
    private LocalDate expiresAt;
}
