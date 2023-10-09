package com.example.ekyc.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Credential_TBL")
public class UserCredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private UUID userId;

    private String userName;
    private String email;
    private String phoneNumber;
    private String password;

    @Column(columnDefinition = "varchar(255) default 'User'")
    private String role;

}