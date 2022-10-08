package com.school.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.user.model.User;
import com.school.modules.user.repository.UserRepository;

@Service
public class CreateUserService {
    
    @Autowired
    UserRepository userRepository;

    public User execute(User user) {
        User existUser = userRepository.findByEmail(user.getEmail());

        if (existUser != null) {
            throw new Error("Usuário já existe.");
        }

        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
