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
public class ApplicationStatusEntity {

    @Id
    @Column(name= "applicationStatusId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID applicationStatusId;

    @Column(name= "applicationId")
    private UUID applicationId;
    @Column(name= "userID")
    private UUID userID;
    @Column(name= "applicationType")
    private String applicationType;
    @Column(name= "applicationDate")
    private Date applicationDate;
    @Column(name= "applicationStatus")
    private String applicationStatus;
    @Column(name= "applicationRemarks")
    private String applicationRemarks;
}
