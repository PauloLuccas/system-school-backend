package com.school.modules.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.user.model.User;
import com.school.modules.user.repository.UserRepository;

@Service
public class ListUserService {
    
    @Autowired
    UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

}
