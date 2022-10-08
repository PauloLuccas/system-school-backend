package com.school.modules.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.modules.user.model.Classes;

public interface ClassesRepository extends JpaRepository<Classes, UUID> {
    
    Classes findByClassNumber(Long classNumber);

}
