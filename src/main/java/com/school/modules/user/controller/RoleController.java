package com.school.modules.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.user.dto.UserRoleDTO;
import com.school.modules.user.model.Role;
import com.school.modules.user.model.User;
import com.school.modules.user.services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    
    @Autowired
    RoleService roleService;

    @GetMapping
    public @ResponseBody List<Role> list() {
        return roleService.listAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody UserRoleDTO userRoleDTO) {
        return roleService.execute(userRoleDTO);
    }

    // @PostMapping("/create")
    // public Role create(@RequestBody Role role) {
    //     return roleService.execute(role);
    // }
}
