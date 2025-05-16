package com.fivestars.rocketnotes.admins.domain.model.commands;


public record CreateStudentCommand(String firstName, String paternalLastName, String maternalLastName, String dni) {}

