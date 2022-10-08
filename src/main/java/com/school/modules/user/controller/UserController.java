package com.school.modules.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.modules.user.model.User;
import com.school.modules.user.services.CreateUserService;
import com.school.modules.user.services.ListUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final ListUserService listUserService;
    private final CreateUserService createUserService;

    public UserController(ListUserService listUserService, CreateUserService createUserService) {
        this.listUserService = listUserService;
        this.createUserService = createUserService;
    }

    @GetMapping
    public @ResponseBody List<User> list() {
        return listUserService.listAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return createUserService.execute(user);
    }
}
