package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTeacherResource {
    private String firstName;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;
    private String phone;
    private String email;
}
