package com.school.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.models.UserModel;
import com.school.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserModel save(UserModel userModel) {

        try {
            Optional<UserModel> userExistsCPF = userRepository.findByCpf(userModel.getCpf());
            Optional<UserModel> userExistsEmail = userRepository.findByEmail(userModel.getEmail());
            Optional<UserModel> userExistsUsername = userRepository.findByUsername(userModel.getUsername());

            if(userExistsCPF.isEmpty()) {
                throw new IllegalArgumentException("Usuário não existente com o CPF: " + userModel.getCpf());
            }

            if(userExistsEmail.isEmpty()) {
                throw new IllegalArgumentException("Usuário não existente com o E-mail: " + userModel.getEmail());
            }

            if(userExistsUsername.isEmpty()) {
                throw new IllegalArgumentException("Usuário não existente com o Username: " + userModel.getUsername());
            }

            return userRepository.save(userModel); 

        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao tentar salvar o usuário.");
        }
    }

    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }

    public List<UserModel> listAll() {
        return userRepository.findAll();
    }
}
