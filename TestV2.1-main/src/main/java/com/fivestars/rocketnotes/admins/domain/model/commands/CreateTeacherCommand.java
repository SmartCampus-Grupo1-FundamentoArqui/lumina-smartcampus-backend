package com.fivestars.rocketnotes.admins.domain.model.commands;

public record CreateTeacherCommand(String firstName, String paternalLastName, String maternalLastName, String dni, String phone, String email) {}
