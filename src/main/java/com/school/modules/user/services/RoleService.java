package com.school.modules.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.user.model.Role;
import com.school.modules.user.repository.RoleRepository;

@Service
public class RoleService {
    
    @Autowired
    RoleRepository roleRepository;

    public List<Role> listAll() {
        return roleRepository.findAll();
    }

    public Role execute(Role role) {
        Role existRole = roleRepository.findByName(role.getName());

        if (existRole != null) {
            throw new Error("Permissão já existe.");
        }

        return roleRepository.save(role);
    }
}
