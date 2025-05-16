package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.aggregates.Teacher;

import java.util.List;

public interface TeacherQueryService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
}