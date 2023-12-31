package com.example.ekyc.service;

import com.example.ekyc.DTO.UserDTO;
import com.example.ekyc.entity.UserEntity;
import com.example.ekyc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    UserEntity userEntity = new UserEntity();

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID addUser(UserDTO userdto) {
        UserEntity userEntity = new UserEntity();
        // todo check if the username is unique or not
        // todo check email and phone no unique
        boolean byUserName = userRepository.existsByUserName(userdto.getUserName());
        if (!byUserName) {
            userEntity = userEntity.builder()
                    .email(userdto.getEmail())
                    .userName(userdto.getUserName())
                    .userRole(userdto.getUserRole())
                    .phoneNumber(userdto.getPhoneNumber())
                    .salt(userdto.getSalt())
                    .saltedPasswordHash(userdto.getSaltedPasswordHash())
                    .surName(userdto.getSurName())
                    .givenName(userdto.getGivenName())
                    .fathersName(userdto.getFathersName())
                    .mothersName(userdto.getMothersName())
                    .gender(userdto.getGender())
                    .nationality(userdto.getNationality())
                    .nidNumber(userdto.getNidNumber())
                    .dateOfBirth(userdto.getDateOfBirth())
//                    .userPhotoDocumentId(userEntity.getUserPhotoDocumentId())
//                    .nidFrontDocumentId(userdto.getNidFrontDocumentId())
//                    .nidBackDocumentId(userdto.getNidBackDocumentId())
                    .build();
            userEntity = userRepository.save(userEntity);
            return userEntity.getUserId();
        } else throw new RuntimeException("Username not unique");
    }

    public UserDTO getUserById(UUID userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);

        if (optionalUserEntity.isPresent()) {

            UserEntity userEntity = optionalUserEntity.get();

            UserDTO userDTO = UserDTO.builder()
                    .userName(userEntity.getUserName())
                    .email(userEntity.getEmail())
                    .userName(userEntity.getUserName())
                    .userRole(userEntity.getUserRole())
                    .phoneNumber(userEntity.getPhoneNumber())
                    .salt(userEntity.getSalt())
                    .saltedPasswordHash(userEntity.getSaltedPasswordHash())
                    .surName(userEntity.getSurName())
                    .givenName(userEntity.getGivenName())
                    .fathersName(userEntity.getFathersName())
                    .mothersName(userEntity.getMothersName())
                    .gender(userEntity.getGender())
                    .nationality(userEntity.getNationality())
                    .nidNumber(userEntity.getNidNumber())
                    .dateOfBirth(userEntity.getDateOfBirth())
                    .build();
            return userDTO;
        } else {
            return null;
        }
    }

    public boolean updateUser(UUID userId, UserDTO userdto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            userEntity.setEmail(userdto.getEmail());
            userEntity.setUserName(userdto.getUserName());
            userEntity.setUserRole(userdto.getUserRole());
            userEntity.setPhoneNumber(userdto.getPhoneNumber());
            userEntity.setSalt(userdto.getSalt());
            userEntity.setSaltedPasswordHash(userdto.getSaltedPasswordHash());
            userEntity.setSurName(userdto.getSurName());
            userEntity.setGivenName(userdto.getGivenName());
            userEntity.setFathersName(userdto.getFathersName());
            userEntity.setMothersName(userdto.getMothersName());
            userEntity.setGender(userdto.getGender());
            userEntity.setNationality(userdto.getNationality());
            userEntity.setNidNumber(userdto.getNidNumber());
            userEntity.setDateOfBirth(userdto.getDateOfBirth());
            userEntity.setUserPhotoDocumentId(userdto.getUserPhotoDocumentId());
            userEntity.setNidFrontDocumentId(userdto.getNidFrontDocumentId());
            userEntity.setNidBackDocumentId(userdto.getNidBackDocumentId());
            userRepository.save(userEntity);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(UUID userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }
}
