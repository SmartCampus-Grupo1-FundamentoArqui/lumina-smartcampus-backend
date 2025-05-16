package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Admin;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateAdminCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteAdminCommand;
import com.fivestars.rocketnotes.admins.domain.services.AdminCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminCommandServiceImpl implements AdminCommandService {

    private final AdminRepository adminRepository;

    @Override
    public Long handle(CreateAdminCommand command) {
        Admin admin = new Admin(
                command.firstName(),
                command.lastName(),
                command.email(),
                command.password());
        adminRepository.save(admin);
        return admin.getId();
    }


    @Override
    public void handle(DeleteAdminCommand command){
        if (!adminRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Admin does not exist");
        }
        try {
            adminRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting admin: " + e.getMessage());
        }
    }
}