package com.example.ekyc.service;

// src/main/java/com/example/demo/service/UserService.java

import com.example.ekyc.entity.UserCredentialEntity;

import com.example.ekyc.repository.UserCredRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredService {

    @Autowired
    private UserCredRepo userRepository;

    public UserCredentialEntity loginUser(String userName, String password) {
        UserCredentialEntity userCredentialEntity = userRepository.findByUserName(userName);

        if (userCredentialEntity != null && userCredentialEntity.getPassword().equals(password)) {
            return userCredentialEntity;
        }

        return null;
    }
}

