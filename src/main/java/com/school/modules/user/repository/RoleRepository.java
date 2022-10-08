package com.school.modules.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.modules.user.model.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    
    Role findByName(String name);

}
