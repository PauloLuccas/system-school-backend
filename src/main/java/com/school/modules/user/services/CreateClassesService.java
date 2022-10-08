package com.school.modules.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.user.model.Classes;
import com.school.modules.user.repository.ClassesRepository;

@Service
public class CreateClassesService {
    
    @Autowired
    ClassesRepository classesRepository;

    public Classes execute(Classes classes) {
        Classes existClasses = classesRepository.findByClassNumber(classes.getClassNumber());

        if (existClasses != null) {
            throw new Error("Turma já existe.");
        }

        Classes createClasses = classesRepository.save(classes);

        return createClasses;
    }
}
