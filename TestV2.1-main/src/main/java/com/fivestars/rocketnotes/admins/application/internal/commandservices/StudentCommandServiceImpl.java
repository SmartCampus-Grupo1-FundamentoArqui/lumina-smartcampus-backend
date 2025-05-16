package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Student;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteStudentCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.services.StudentCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;

    @Override
    public Long handle(CreateStudentCommand command) {
        Student student = new Student(
                command.firstName(),
                command.paternalLastName(),
                command.maternalLastName(),
                command.dni());
        studentRepository.save(student);
        return student.getId();
    }

    @Override
    public void handle(UpdateStudentCommand command) {
        Student student = studentRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Student not found"));
        student.updateDetails(command.firstName(), command.paternalLastName(), command.maternalLastName(), command.dni());
        studentRepository.save(student);
    }

    @Override
    public void handle(DeleteStudentCommand command){
        if (!studentRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Student does not exist");
        }
        try {
            studentRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting student: " + e.getMessage());
        }
    }

}