package com.school.modules.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.user.model.User;
import com.school.modules.user.services.ListUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final ListUserService listUserService;

    public UserController(ListUserService listUserService) {
        this.listUserService = listUserService;
    }

    @GetMapping
    public @ResponseBody List<User> list() {
        return listUserService.listAll();
    }
}
