package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAdminResource {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}