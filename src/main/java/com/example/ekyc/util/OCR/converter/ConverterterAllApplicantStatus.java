package com.example.ekyc.util.OCR.converter;

import com.example.ekyc.DTO.ApplicationDTO;
import com.example.ekyc.DTO.ApplicationStatusDTO;
import com.example.ekyc.entity.ApplicationStatusEntity;
import com.example.ekyc.entity.IndividualApplicationEntity;

public class ConverterterAllApplicantStatus {
    public static ApplicationStatusDTO convertToDto(ApplicationStatusEntity e) {

        ApplicationStatusDTO applicationStatusDTO = new ApplicationStatusDTO();
        applicationStatusDTO.setApplicationId(e.getApplicationId());
        applicationStatusDTO.setUserID(e.getUserID());
        applicationStatusDTO.setApplicationType(e.getApplicationType());
        applicationStatusDTO.setApplicationDate(e.getApplicationDate());
        applicationStatusDTO.setApplicationStatus(e.getApplicationStatus());
        applicationStatusDTO.setApplicationRemarks(e.getApplicationRemarks());

        return applicationStatusDTO;
    }
}
