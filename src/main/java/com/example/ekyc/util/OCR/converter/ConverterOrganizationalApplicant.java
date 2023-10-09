package com.example.ekyc.util.OCR.converter;

import com.example.ekyc.DTO.ApplicationDTO;
import com.example.ekyc.entity.OrganizationApplicationEntity;

public class ConverterOrganizationalApplicant {
    public static ApplicationDTO convertToDto(OrganizationApplicationEntity e) {
        ApplicationDTO applicationDTO = new ApplicationDTO();

        applicationDTO.setCertificateType(e.getCertificateType());
        applicationDTO.setCertificateClass(e.getCertificateClass());
        applicationDTO.setCertificateValidityYears(e.getCertificateValidityYears());
        applicationDTO.setHouseNumber(e.getHouseNumber());
        applicationDTO.setStreetAddress(e.getStreetAddress());
        applicationDTO.setCity(e.getCity());
        applicationDTO.setPostCode(e.getPostCode());
        applicationDTO.setDistrict(e.getDistrict());
        applicationDTO.setCountry(e.getCountry());
        applicationDTO.setTinDocumentId(e.getTinDocumentId());
        applicationDTO.setPassportDocumentId(e.getPassportDocumentId());
        applicationDTO.setUtilityBillType(e.getUtilityBillType());
        applicationDTO.setUtilityBillDocumentId(e.getUtilityBillDocumentId());
        applicationDTO.setOrgType(e.getOrgType());
        applicationDTO.setOrgName(e.getOrgName());
        applicationDTO.setApplicantDesignation(e.getApplicantDesignation());
        applicationDTO.setApplicantDepartment(e.getApplicantDepartment());
        applicationDTO.setOrgHouseNumber(e.getOrgHouseNumber());
        applicationDTO.setOrgStreetAddress(e.getOrgStreetAddress());
        applicationDTO.setOrgCity(e.getOrgCity());
        applicationDTO.setOrgPostCode(e.getOrgPostCode());
        applicationDTO.setOrgDistrict(e.getOrgDistrict());
        applicationDTO.setOrgCountry(e.getOrgCountry());
        //applicationDTO.setEmployeeDocumentId(e.getEmployeeDocumentId());
        applicationDTO.setTinDocumentId(e.getTinDocumentId());
        applicationDTO.setEmployeeDocumentId(e.getEmployeeDocumentId());
        applicationDTO.setApplicantDepartment(e.getApplicantDepartment());

        return applicationDTO;
    }
}
