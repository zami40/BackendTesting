package com.example.ekyc.DTO;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
//    private String userName;
//
//    private String userRole;
//
//    private String email;
//    private String phoneNumber;

//    private String salt;
//
//    private String saltedPasswordHash;
    private String surName;

    private String givenName;

    private String fathersName;

    private String mothersName;

    private String gender;

    private String nationality;

    private int nidNumber;

    private String dateOfBirth;

    private UUID userPhotoDocumentId;

    private UUID nidFrontDocumentId;

    private UUID nidBackDocumentId;

    //UserCredential table data
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;


}

