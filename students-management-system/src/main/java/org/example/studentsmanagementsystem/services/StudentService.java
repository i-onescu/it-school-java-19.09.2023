package org.example.studentsmanagementsystem.services;

import org.example.studentsmanagementsystem.models.Badge;
import org.example.studentsmanagementsystem.models.Student;
import org.example.studentsmanagementsystem.models.dtos.BadgeDTO;
import org.example.studentsmanagementsystem.models.dtos.StudentDTO;
import org.example.studentsmanagementsystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentDTO getStudentById(Long id) {
        Student studentById = repository.getStudentById(id);
        Badge badge = studentById.getBadge();

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setAge(studentById.getAge());
        studentDTO.setFirstName(studentById.getFirstName());
        studentDTO.setLastName(studentById.getLastName());

        BadgeDTO badgeDTO = new BadgeDTO();
        badgeDTO.setExpiresAt(badge.getExpiresAt());
        badgeDTO.setIssuedAt(badge.getIssuedAt());

        studentDTO.setBadge(badgeDTO);
        return studentDTO;
    }
}
