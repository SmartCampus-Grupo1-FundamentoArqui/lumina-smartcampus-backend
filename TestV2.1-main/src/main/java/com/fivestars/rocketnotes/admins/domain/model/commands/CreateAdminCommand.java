package com.fivestars.rocketnotes.admins.domain.model.commands;


public record CreateAdminCommand(String firstName, String lastName, String email, String password) {}