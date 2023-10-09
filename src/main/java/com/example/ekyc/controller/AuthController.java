package com.example.ekyc.controller;

import com.example.ekyc.DTO.UserCredRequestDTO;
import com.example.ekyc.DTO.UserCredResponseDTO;
import com.example.ekyc.entity.UserCredentialEntity;
import com.example.ekyc.service.UserCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private UserCredService userCredService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredRequestDTO userCredRequestDTO) {
        UserCredentialEntity userCredentialEntity = userCredService.loginUser(userCredRequestDTO.getUserName(), userCredRequestDTO.getPassword());

        if (userCredentialEntity != null) {
            return ResponseEntity.ok(new UserCredResponseDTO(userCredentialEntity.getUserId(), userCredentialEntity.getRole()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}