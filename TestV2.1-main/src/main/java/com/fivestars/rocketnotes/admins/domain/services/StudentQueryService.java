package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.aggregates.Student;

import java.util.List;

public interface StudentQueryService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
}

