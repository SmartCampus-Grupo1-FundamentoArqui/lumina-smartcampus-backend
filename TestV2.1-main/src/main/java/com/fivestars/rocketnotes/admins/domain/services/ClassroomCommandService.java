package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.commands.*;

public interface ClassroomCommandService {
    Long handle(CreateClassroomCommand command);
    void handle(AddStudentToClassroomCommand command);
    void handle(RemoveStudentFromClassroomCommand command);
    Long handle(CreateCourseCommand command);
    void handle(DeleteCourseCommand command);
}
