package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Teacher;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.services.TeacherCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherCommandServiceImpl implements TeacherCommandService {

    private final TeacherRepository teacherRepository;

    @Override
    public Long handle(CreateTeacherCommand command) {
        Teacher teacher = new Teacher(
                command.firstName(),
                command.paternalLastName(),
                command.maternalLastName(),
                command.dni(),
                command.phone(),
                command.email()
        );
        teacherRepository.save(teacher);
        return teacher.getId();
    }

    @Override
    public void handle(UpdateTeacherCommand command) {
        Teacher teacher = teacherRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacher.updateDetails(command.firstName(), command.paternalLastName(), command.maternalLastName(), command.dni(), command.phone(), command.email());
        teacherRepository.save(teacher);
    }

    @Override
    public void handle(DeleteTeacherCommand command){
        if (!teacherRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Teacher does not exist");
        }
        try {
            teacherRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting teacher: " + e.getMessage());
        }
    }
}