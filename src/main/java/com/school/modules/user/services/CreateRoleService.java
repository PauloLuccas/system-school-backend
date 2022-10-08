package com.school.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.user.model.Role;
import com.school.modules.user.repository.RoleRepository;

@Service
public class CreateRoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role execute(Role role) {
        Role existRole = roleRepository.findByName(role.getName());

        if (existRole != null) {
            throw new Error("Permissão já existe.");
        }

        Role createdRole = roleRepository.save(role);

        return createdRole;
    }
}
