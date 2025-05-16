package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.aggregates.Admin;

import java.util.List;


public interface AdminQueryService {
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
}
