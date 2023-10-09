package com.example.ekyc.controller;

import com.example.ekyc.DTO.UserDTO;
import com.example.ekyc.DTO.UserIdDTO;
import com.example.ekyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
public class UserController{

    private  final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UUID> addUser(@RequestBody UserDTO userdto){
        UUID user = userService.addUser(userdto);
        // userService.addUserCredential(userdto);
        if(user != null){
            return ResponseEntity.ok(user);
        }
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId){
        UserDTO userDTO = userService.getUserById(userId);
        if(userDTO != null){
            return ResponseEntity.ok(userDTO);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<UserIdDTO> updateUser(@PathVariable UUID userId, @RequestBody UserDTO userdto) {
        boolean updated = userService.updateUser(userId, userdto);
        UserIdDTO userIdDTO = new UserIdDTO();
        userIdDTO.setUserId(userId);
        if (updated) {
            return ResponseEntity.ok(userIdDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<UserIdDTO> deleteUser(@PathVariable UUID userId) {
        boolean deleted = userService.deleteUser(userId);
        UserIdDTO userIdDTO = new UserIdDTO();
        userIdDTO.setUserId(userId);
        if (deleted) {
            return ResponseEntity.ok(userIdDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
