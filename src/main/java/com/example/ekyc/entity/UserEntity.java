package com.example.ekyc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_TBL")
public class UserEntity  {
    @Id
    @Column(name= "userId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    //    @Column(name= "userName")
//    private String userName;
//    @Column(name= "userRole")
//    private String userRole;
//    @Column(name= "email")
//    private String email;
//    @Column(name= "phoneNumber")
//    private String phoneNumber;
//    @Column(name= "salt")
//    private String salt;
//    @Column(name= "saltedPasswordHash")
//    private String saltedPasswordHash;
    @Column(name= "surName")
    private String surName;
    @Column(name= "givenName")
    private String givenName;
    @Column(name= "fathersName")
    private String fathersName;
    @Column(name= "mothersName")
    private String mothersName;
    @Column(name= "gender")
    private String gender;
    @Column(name= "nationality")
    private String nationality;
    @Column(name= "nidNumber")
    private int nidNumber;
    @Column(name= "dateOfBirth")
    private String dateOfBirth;
    @Column(name= "userPhotoDocumentId")
    private UUID userPhotoDocumentId;
    @Column(name= "nidFrontDocumentId")
    private UUID nidFrontDocumentId;
    @Column(name= "nidBackDocumentId")
    private UUID nidBackDocumentId;

}