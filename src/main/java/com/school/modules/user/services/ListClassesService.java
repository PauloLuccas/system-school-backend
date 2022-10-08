package com.school.modules.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.user.model.Classes;
import com.school.modules.user.repository.ClassesRepository;

@Service
public class ListClassesService {
    
    @Autowired
    ClassesRepository classesRepository;

    public List<Classes> listAll() {
        return classesRepository.findAll();
    }
}
