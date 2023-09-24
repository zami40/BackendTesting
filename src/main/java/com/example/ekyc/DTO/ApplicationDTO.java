package com.example.ekyc.DTO;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {

    private String certificateType;

    private String houseNumber;

    private String streetAddress;

    private String city;

    private String postCode;

    private String district;

    private String country;

    private UUID tinDocumentId;

    private UUID passportDocumentId;

    private UUID utilityBillType;

    private UUID utilityBillDocumentId;

    private UUID otherDocumentId;

    private String orgType;

    private String orgName;

    private String applicantDesignation;

    private String applicantDepartment;

    private String orgHouseNumber;

    private String orgStreetAddress;

    private String orgCity;

    private String orgPostCode;

    private String orgDistrict;

    private String orgCountry;

    private UUID employeeDocumentId;

    private UUID approvalLetterDocumentId;
}
