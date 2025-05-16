package com.fivestars.rocketnotes.admins.domain.model.commands;

public record AddStudentToClassroomCommand(Long roomId, Long studentId) {
}
