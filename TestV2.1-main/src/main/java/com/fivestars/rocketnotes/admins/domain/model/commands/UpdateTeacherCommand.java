package com.fivestars.rocketnotes.admins.domain.model.commands;

public record UpdateTeacherCommand(Long id, String firstName, String paternalLastName, String maternalLastName, String dni, String phone, String email) {}

