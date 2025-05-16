package com.fivestars.rocketnotes.admins.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String days;

    @ManyToOne
    private Teacher teacher;

    @Lob
    private byte[] image;

    public Course(String name, LocalDate start, LocalDate end, String days, Teacher teacher, byte[] image) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.days = days;
        this.teacher = teacher;
        this.image = image;
    }
}
