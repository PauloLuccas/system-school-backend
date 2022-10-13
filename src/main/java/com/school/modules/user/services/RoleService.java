package com.school.modules.user.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.modules.user.dto.UserRoleDTO;
import com.school.modules.user.model.Role;
import com.school.modules.user.model.User;
import com.school.modules.user.repository.RoleRepository;
import com.school.modules.user.repository.UserRepository;

@Service
public class RoleService {
    
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    public List<Role> listAll() {
        return roleRepository.findAll();
    }

    public User execute(UserRoleDTO userRoleDTO) {
        Optional<User> userExists = userRepository.findById(userRoleDTO.getIdUser());
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("Usuário não existente!");
        }

        roles = userRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        User user = userExists.get();

        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }

    // public Role execute(Role role) {
    //     Role existRole = roleRepository.findByName(role.getName());

    //     if (existRole != null) {
    //         throw new Error("Permissão já existe.");
    //     }

    //     return roleRepository.save(role);
    // }
}
