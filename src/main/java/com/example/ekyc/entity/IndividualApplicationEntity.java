package com.example.ekyc.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INDIVIDUAL_APPLICATION_TBL")
public class IndividualApplicationEntity {
    @Id
    @Column(name= "applicationId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID applicationId;
    @Column(name= "certificateType")
    private String certificateType;
    @Column(name= "houseNumber")
    private String houseNumber;
    @Column(name= "streetAddress")
    private String streetAddress;
    @Column(name= "city")
    private String city;
    @Column(name= "postCode")
    private String postCode;
    @Column(name= "district")
    private String district;
    @Column(name= "country")
    private String country;
    @Column(name= "tinDocumentId")
    private UUID tinDocumentId;
    @Column(name= "passportDocumentId")
    private UUID passportDocumentId;
    @Column(name= "utilityBillType")
    private String utilityBillType;
    @Column(name= "utilityBillDocumentId")
    private UUID utilityBillDocumentId;
    @Column(name= "otherDocumentId")
    private UUID otherDocumentId;
}
