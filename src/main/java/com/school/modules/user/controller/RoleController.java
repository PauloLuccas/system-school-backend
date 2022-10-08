package com.school.modules.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.user.model.Role;
import com.school.modules.user.services.CreateRoleService;
import com.school.modules.user.services.ListRoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    
    @Autowired
    CreateRoleService createRoleService;

    @Autowired
    ListRoleService listRoleService;

    @GetMapping
    public @ResponseBody List<Role> list() {
        return listRoleService.listAll();
    }

    @PostMapping("/create")
    public Role create(@RequestBody Role role) {
        return createRoleService.execute(role);
    }
}
