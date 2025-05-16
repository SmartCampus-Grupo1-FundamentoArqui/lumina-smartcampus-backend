package com.fivestars.rocketnotes.admins.domain.model.commands;

public record RemoveStudentFromClassroomCommand(Long roomId, Long studentId) {
}
