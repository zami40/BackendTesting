package com.example.ekyc.service;

import com.example.ekyc.DTO.ApplicationDTO;
import com.example.ekyc.entity.IndividualApplicationEntity;
import com.example.ekyc.entity.OrganizationApplicationEntity;
import com.example.ekyc.repository.IndividualApplicationRepository;
import com.example.ekyc.repository.OrganizationApplicationRepository;
import com.example.ekyc.util.OCR.converter.ConverterIndividaualApplicant;
import com.example.ekyc.util.OCR.converter.ConverterOrganizationalApplicant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final IndividualApplicationRepository individualApplicationRepository;

    private final OrganizationApplicationRepository organizationApplicationRepository;

    public UUID addIndividualOrganizationalUser(String applicationType, ApplicationDTO applicationDTO) {
        if (applicationType.equals("individual")) {
            IndividualApplicationEntity individualApplicationEntity = new IndividualApplicationEntity();
            individualApplicationEntity = individualApplicationEntity.builder()
                    .certificateType(applicationDTO.getCertificateType())
                    .houseNumber(applicationDTO.getHouseNumber())
                    .streetAddress(applicationDTO.getStreetAddress())
                    .city(applicationDTO.getCity())
                    .postCode(applicationDTO.getPostCode())
                    .district(applicationDTO.getDistrict())
                    .country(applicationDTO.getCountry())
                    .tinDocumentId(applicationDTO.getTinDocumentId())
                    .passportDocumentId(applicationDTO.getPassportDocumentId())
                    .utilityBillType(applicationDTO.getUtilityBillType())
                    .utilityBillDocumentId(applicationDTO.getUtilityBillDocumentId())
                    .otherDocumentId(applicationDTO.getOtherDocumentId())
                    .build();
//            individualApplicationRepository.save(individualApplicationEntity);

            individualApplicationEntity = individualApplicationRepository.save(individualApplicationEntity);
            //
            return individualApplicationEntity.getApplicationId();
        } else if (applicationType.equals("organizational")) {

            OrganizationApplicationEntity organizationApplicationEntity = new OrganizationApplicationEntity();

            organizationApplicationEntity = organizationApplicationEntity.builder()
                    .certificateType(applicationDTO.getCertificateType())
                    .houseNumber(applicationDTO.getHouseNumber())
                    .streetAddress(applicationDTO.getStreetAddress())
                    .city(applicationDTO.getCity())
                    .postCode(applicationDTO.getPostCode())
                    .district(applicationDTO.getDistrict())
                    .country(applicationDTO.getCountry())
                    .orgType(applicationDTO.getOrgType())
                    .orgName(applicationDTO.getOrgName())
                    .applicantDesignation(applicationDTO.getApplicantDesignation())
                    .applicantDepartment(applicationDTO.getApplicantDepartment())
                    .orgHouseNumber(applicationDTO.getOrgHouseNumber())
                    .orgCity(applicationDTO.getOrgCity())
                    .orgPostCode(applicationDTO.getOrgPostCode())
                    .orgDistrict(applicationDTO.getOrgDistrict())
                    .orgCountry(applicationDTO.getOrgCountry())
                    .tinDocumentId(applicationDTO.getTinDocumentId())
                    .passportDocumentId(applicationDTO.getPassportDocumentId())
                    .utilityBillType(applicationDTO.getUtilityBillType())
                    .utilityBillDocumentId(applicationDTO.getUtilityBillDocumentId())
                    .employeeDocumentId(applicationDTO.getEmployeeDocumentId())
                    .approvalLetterDocumentId(applicationDTO.getApprovalLetterDocumentId())
                    .build();
            organizationApplicationEntity = organizationApplicationRepository.save(organizationApplicationEntity);
            return organizationApplicationEntity.getApplicationId();
        }
        return null;
    }

    public ApplicationDTO getApplicantById(String applicationType, UUID applicantId) {
        if (applicationType.equals("individual")) {
            Optional<IndividualApplicationEntity> optionalIndividualApplicationEntity = individualApplicationRepository.findById(applicantId);

            if (optionalIndividualApplicationEntity.isPresent()) {
                IndividualApplicationEntity individualApplicationEntity = optionalIndividualApplicationEntity.get();

                ApplicationDTO applicationDTO = ApplicationDTO.builder()
                        .certificateType(individualApplicationEntity.getCertificateType())
                        .houseNumber(individualApplicationEntity.getHouseNumber())
                        .streetAddress(individualApplicationEntity.getStreetAddress())
                        .city(individualApplicationEntity.getCity())
                        .postCode(individualApplicationEntity.getPostCode())
                        .district(individualApplicationEntity.getDistrict())
                        .country(individualApplicationEntity.getCountry())
                        .tinDocumentId(individualApplicationEntity.getTinDocumentId())
                        .passportDocumentId(individualApplicationEntity.getPassportDocumentId())
                        .utilityBillType(individualApplicationEntity.getUtilityBillType())
                        .utilityBillDocumentId(individualApplicationEntity.getUtilityBillDocumentId())
                        .otherDocumentId(individualApplicationEntity.getOtherDocumentId())
                        .build();


//                ApplicationDTO applicationDTO = new ApplicationDTO();


//                applicationDTO.setApplicationId(individualApplicationEntity.getApplicationId());
//                applicationDTO.setCertificateType(individualApplicationEntity.getCertificateType());
//                applicationDTO.setHouseNumber(individualApplicationEntity.getHouseNumber());
//                applicationDTO.setStreetAddress(individualApplicationEntity.getStreetAddress());
//                applicationDTO.setCity(individualApplicationEntity.getCity());
//                applicationDTO.setPostCode(individualApplicationEntity.getPostCode());
//                applicationDTO.setDistrict(individualApplicationEntity.getDistrict());
//                applicationDTO.setCountry(individualApplicationEntity.getCountry());
//                applicationDTO.setTinDocumentId(individualApplicationEntity.getTinDocumentId());
//                applicationDTO.setPassportDocumentId(individualApplicationEntity.getPassportDocumentId());
//                applicationDTO.setUtilityBillType(individualApplicationEntity.getUtilityBillType());
//                applicationDTO.setUtilityBillDocumentId(individualApplicationEntity.getUtilityBillDocumentId());
//                applicationDTO.setOtherDocumentId(individualApplicationEntity.getOtherDocumentId());
                return applicationDTO;
            } else {
                return null;
            }
        } else {
            Optional<OrganizationApplicationEntity> optionalOrganizationApplicationEntity = organizationApplicationRepository.findById(applicantId);

            if (optionalOrganizationApplicationEntity.isPresent()) {
                OrganizationApplicationEntity organizationApplicationEntity = optionalOrganizationApplicationEntity.get();
                ApplicationDTO applicationDTO = ApplicationDTO.builder()
                        .certificateType(organizationApplicationEntity.getCertificateType())
                        .houseNumber(organizationApplicationEntity.getHouseNumber())
                        .streetAddress(organizationApplicationEntity.getStreetAddress())
                        .city(organizationApplicationEntity.getCity())
                        .postCode(organizationApplicationEntity.getPostCode())
                        .district(organizationApplicationEntity.getDistrict())
                        .country(organizationApplicationEntity.getCountry())
                        .orgType(organizationApplicationEntity.getOrgType())
                        .orgName(organizationApplicationEntity.getOrgName())
                        .applicantDesignation(organizationApplicationEntity.getApplicantDesignation())
                        .applicantDepartment(organizationApplicationEntity.getApplicantDepartment())
                        .orgHouseNumber(organizationApplicationEntity.getOrgHouseNumber())
                        .orgCity(organizationApplicationEntity.getOrgCity())
                        .orgPostCode(organizationApplicationEntity.getOrgPostCode())
                        .orgDistrict(organizationApplicationEntity.getOrgDistrict())
                        .orgCountry(organizationApplicationEntity.getOrgCountry())
                        .tinDocumentId(organizationApplicationEntity.getTinDocumentId())
                        .passportDocumentId(organizationApplicationEntity.getPassportDocumentId())
                        .utilityBillType(organizationApplicationEntity.getUtilityBillType())
                        .utilityBillDocumentId(organizationApplicationEntity.getUtilityBillDocumentId())
                        .employeeDocumentId(organizationApplicationEntity.getEmployeeDocumentId())
                        .approvalLetterDocumentId(organizationApplicationEntity.getApprovalLetterDocumentId())
                        .build();


////                ApplicationDTO applicationDTO = new ApplicationDTO();
//                applicationDTO.setApplicationId(organizationApplicationEntity.getApplicationId());
//                applicationDTO.setCertificateType(organizationApplicationEntity.getCertificateType());
//                applicationDTO.setHouseNumber(organizationApplicationEntity.getHouseNumber());
//                applicationDTO.setStreetAddress(organizationApplicationEntity.getStreetAddress());
//                applicationDTO.setCity(organizationApplicationEntity.getCity());
//                applicationDTO.setPostCode(organizationApplicationEntity.getPostCode());
//                applicationDTO.setDistrict(organizationApplicationEntity.getDistrict());
//                applicationDTO.setCountry(organizationApplicationEntity.getCountry());
//                applicationDTO.setTinDocumentId(organizationApplicationEntity.getTinDocumentId());
//                applicationDTO.setPassportDocumentId(organizationApplicationEntity.getPassportDocumentId());
//                applicationDTO.setUtilityBillType(organizationApplicationEntity.getUtilityBillType());
//                applicationDTO.setUtilityBillDocumentId(organizationApplicationEntity.getUtilityBillDocumentId());
//                //applicationDTO.setOtherDocumentId(organizationApplicationEntity.getOtherDocumentId());
//                applicationDTO.setOrgType(organizationApplicationEntity.getOrgType());
//                applicationDTO.setOrgName(organizationApplicationEntity.getOrgType());
//                applicationDTO.setApplicantDesignation(organizationApplicationEntity.getApplicantDesignation());
//                applicationDTO.setApplicantDepartment(organizationApplicationEntity.getApplicantDepartment());
//                applicationDTO.setOrgHouseNumber(organizationApplicationEntity.getOrgHouseNumber());
//                applicationDTO.setOrgStreetAddress(organizationApplicationEntity.getOrgStreetAddress());
//                applicationDTO.setOrgCity(organizationApplicationEntity.getOrgCity());
//                applicationDTO.setOrgPostCode(organizationApplicationEntity.getOrgPostCode());
//                applicationDTO.setOrgDistrict(organizationApplicationEntity.getOrgDistrict());
//                applicationDTO.setOrgCountry(organizationApplicationEntity.getOrgCountry());
//                applicationDTO.setEmployeeDocumentId(organizationApplicationEntity.getEmployeeDocumentId());
//                applicationDTO.setApprovalLetterDocumentId(organizationApplicationEntity.getApprovalLetterDocumentId());
                return applicationDTO;
            } else {
                return null;
            }
        }
    }

    public List<ApplicationDTO> getIndividualOrganizationalUser(String applicationType) {
        List<ApplicationDTO> applicationDTOList = new ArrayList<>();
        if (applicationType.equals("individual")) {
            List<IndividualApplicationEntity> individualApplicationEntity = individualApplicationRepository.findAll();
//           List<ApplicationDTO> applicationDTOList = new ArrayList<>();

            applicationDTOList = individualApplicationEntity.stream()
                    .map(ConverterIndividaualApplicant::convertToDto).toList();
            }
        else if (applicationType.equals("organizational")) {
            List<OrganizationApplicationEntity> organizationApplicationEntity = organizationApplicationRepository.findAll();

            applicationDTOList = organizationApplicationEntity.stream()
                    .map(ConverterOrganizationalApplicant::convertToDto).toList();
        }
        return applicationDTOList;
    }

    public boolean updateApplicant(String applicationType, UUID applicantId, ApplicationDTO applicationDTO) {
        if (applicationType.equals("individual")) {
            Optional<IndividualApplicationEntity> optionalIndividualApplicationEntity = individualApplicationRepository.findById(applicantId);
            if (optionalIndividualApplicationEntity.isPresent()) {
                IndividualApplicationEntity individualApplicationEntity = optionalIndividualApplicationEntity.get();

//                individualApplicationEntity.setApplicationId(applicationDTO.getApplicationId());
                individualApplicationEntity.setCertificateType(applicationDTO.getCertificateType());
                individualApplicationEntity.setHouseNumber(applicationDTO.getHouseNumber());
                individualApplicationEntity.setStreetAddress(applicationDTO.getStreetAddress());
                individualApplicationEntity.setCity(applicationDTO.getCity());
                individualApplicationEntity.setPostCode(applicationDTO.getPostCode());
                individualApplicationEntity.setDistrict(applicationDTO.getDistrict());
                individualApplicationEntity.setCountry(applicationDTO.getCountry());
                individualApplicationEntity.setTinDocumentId(applicationDTO.getTinDocumentId());
                individualApplicationEntity.setPassportDocumentId(applicationDTO.getPassportDocumentId());
                individualApplicationEntity.setUtilityBillType(applicationDTO.getUtilityBillType());
                individualApplicationEntity.setUtilityBillDocumentId(applicationDTO.getUtilityBillDocumentId());
                individualApplicationEntity.setOtherDocumentId(applicationDTO.getOtherDocumentId());
                individualApplicationRepository.save(individualApplicationEntity);
                return true;
            }
        } else if (applicationType.equals("organizational")) {
            Optional<OrganizationApplicationEntity> optionalIndividualApplicationEntity = organizationApplicationRepository.findById(applicantId);
            if (optionalIndividualApplicationEntity.isPresent()) {
                OrganizationApplicationEntity organizationApplicationEntity = optionalIndividualApplicationEntity.get();

                organizationApplicationEntity.setApplicationId(applicantId);
                organizationApplicationEntity.setCertificateType(applicationDTO.getCertificateType());
                organizationApplicationEntity.setHouseNumber(applicationDTO.getHouseNumber());
                organizationApplicationEntity.setStreetAddress(applicationDTO.getStreetAddress());
                organizationApplicationEntity.setCity(applicationDTO.getCity());
                organizationApplicationEntity.setPostCode(applicationDTO.getPostCode());
                organizationApplicationEntity.setDistrict(applicationDTO.getDistrict());
                organizationApplicationEntity.setCountry(applicationDTO.getCountry());
                organizationApplicationEntity.setTinDocumentId(applicationDTO.getTinDocumentId());
                organizationApplicationEntity.setPassportDocumentId(applicationDTO.getPassportDocumentId());
                organizationApplicationEntity.setUtilityBillType(applicationDTO.getUtilityBillType());
                organizationApplicationEntity.setUtilityBillDocumentId(applicationDTO.getUtilityBillDocumentId());
                organizationApplicationEntity.setOrgType(applicationDTO.getOrgType());
                organizationApplicationEntity.setOrgName(applicationDTO.getOrgName());
                organizationApplicationEntity.setApplicantDesignation(applicationDTO.getApplicantDesignation());
                organizationApplicationEntity.setApplicantDepartment(applicationDTO.getApplicantDepartment());
                organizationApplicationEntity.setOrgHouseNumber(applicationDTO.getOrgHouseNumber());
                organizationApplicationEntity.setOrgStreetAddress(applicationDTO.getOrgStreetAddress());
                organizationApplicationEntity.setOrgCity(applicationDTO.getOrgCity());
                organizationApplicationEntity.setOrgPostCode(applicationDTO.getOrgPostCode());
                organizationApplicationEntity.setOrgDistrict(applicationDTO.getOrgDistrict());
                organizationApplicationEntity.setOrgCountry(applicationDTO.getOrgCountry());
                organizationApplicationEntity.setEmployeeDocumentId(applicationDTO.getEmployeeDocumentId());
                organizationApplicationEntity.setApprovalLetterDocumentId(applicationDTO.getApprovalLetterDocumentId());
                organizationApplicationRepository.save(organizationApplicationEntity);
                return true;
            }
        }
        return false;
    }

    public boolean deleteApplicant(String applicationType, UUID applicantId) {
        if (applicationType.equals("individual")) {
            Optional<IndividualApplicationEntity> optionalIndividualApplicationEntity = individualApplicationRepository.findById(applicantId);
            if (optionalIndividualApplicationEntity.isPresent()) {
                individualApplicationRepository.delete(optionalIndividualApplicationEntity.get());
                return true;
            }

        } else if (applicationType.equals("organizational")) {
            Optional<OrganizationApplicationEntity> optionalIndividualApplicationEntity = organizationApplicationRepository.findById(applicantId);
            if (optionalIndividualApplicationEntity.isPresent()) {
                organizationApplicationRepository.delete(optionalIndividualApplicationEntity.get());
                return true;
            }

        }
        return false;
    }
}
