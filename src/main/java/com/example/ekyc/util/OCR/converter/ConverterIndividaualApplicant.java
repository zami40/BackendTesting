package com.example.ekyc.util.OCR.converter;

import com.example.ekyc.DTO.ApplicationDTO;
import com.example.ekyc.entity.IndividualApplicationEntity;
import com.example.ekyc.entity.OrganizationApplicationEntity;

public class ConverterIndividaualApplicant {
    public static ApplicationDTO convertToDto(IndividualApplicationEntity e) {

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setDistrict(e.getDistrict());
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
        applicationDTO.setOtherDocumentId(e.getOtherDocumentId());
        return applicationDTO;
    }
}