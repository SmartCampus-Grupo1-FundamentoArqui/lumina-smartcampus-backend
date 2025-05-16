package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Data;

@Data
public class CreateClassroomResource {
    private String name;
    private String section;
    private int capacity;
}
