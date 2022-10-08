package com.school.modules.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.modules.user.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
