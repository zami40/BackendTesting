package com.example.ekyc.entity;
        import jakarta.persistence.*;
        import lombok.*;

        import java.util.Date;
        import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORGANIZATION_APPLICATION_TBL")
public class OrganizationApplicationEntity {
    @Id
    @Column(name= "applicationId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID applicationId;
    @Column(name= "certificateType")
    private String certificateType;
    @Column(name= "certificateClass")
    private String certificateClass;
    @Column(name= "certificateValidityYears")
    private int certificateValidityYears;
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
    @Column(name= "orgType")
    private String orgType;
    @Column(name= "orgName")
    private String orgName;
    @Column(name= "applicantDesignation")
    private String applicantDesignation;
    @Column(name= "applicantDepartment")
    private String applicantDepartment;
    @Column(name= "orgHouseNumber")
    private String orgHouseNumber;
    @Column(name= "orgStreetAddress")
    private String orgStreetAddress;
    @Column(name= "orgCity")
    private String orgCity;
    @Column(name= "orgPostCode")
    private String orgPostCode;
    @Column(name= "orgDistrict")
    private String orgDistrict;
    @Column(name= "orgCountry")
    private String orgCountry;
    @Column(name= "employeeDocumentId")
    private UUID employeeDocumentId;
    @Column(name= "approvalLetterDocumentId")
    private UUID approvalLetterDocumentId;
    @Column(name= "orgPhoneNumber")
    private String orgPhoneNumber;

    @Column(name= "binDocumentId")
    private UUID binDocumentId;


}
