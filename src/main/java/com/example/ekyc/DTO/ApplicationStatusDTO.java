package com.example.ekyc.DTO;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationStatusDTO {
    private UUID applicationStatusId;
    private UUID applicationId;
    private UUID userID;
    private String applicationType;
    private Date applicationDate;
    private String applicationStatus;
    private String applicationRemarks;

    public void setApplicationDate(Date applicationDate) {
    }
}