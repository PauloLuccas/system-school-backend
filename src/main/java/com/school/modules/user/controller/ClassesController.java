package com.school.modules.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.user.model.Classes;
import com.school.modules.user.services.CreateClassesService;
import com.school.modules.user.services.ListClassesService;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {
    
    @Autowired
    ListClassesService listClassesService;

    @Autowired
    CreateClassesService createClassesService;

    @GetMapping
    public @ResponseBody List<Classes> list() {
        return listClassesService.listAll();
    }

    @PostMapping("/create")
    public Classes create(@RequestBody Classes classes) {
        return createClassesService.execute(classes);
    }
}
