package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCourseResource {
    private Long roomId;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String days;
    private Long teacherId;
    private byte[] image;
}