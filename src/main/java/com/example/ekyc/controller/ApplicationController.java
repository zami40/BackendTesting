package com.example.ekyc.controller;

import com.example.ekyc.DTO.ApplicationDTO;
import com.example.ekyc.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @PostMapping("/application/{applicationType}")
    public ResponseEntity<UUID> addIndividualOrganizationalUser(@PathVariable String applicationType, @RequestBody ApplicationDTO applicationDTO){
        UUID individualOrganizationalUser = applicationService.addIndividualOrganizationalUser(applicationType,applicationDTO);
        if(individualOrganizationalUser != null){
            return ResponseEntity.ok(individualOrganizationalUser);
        }
        else return ResponseEntity.notFound().build();
    }
    @GetMapping("/application/{applicationType}/{applicationId}")
    public ResponseEntity<ApplicationDTO> getApplicantById(@PathVariable String applicationType, @PathVariable("applicationId") UUID applicantId)
    {
        try{
            ApplicationDTO applicationDTO = applicationService.getApplicantById(applicationType, applicantId);
            if(applicationDTO != null){
                return ResponseEntity.ok(applicationDTO);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }catch (Exception e){
//            e.printStackTrace();
           throw new RuntimeException(e.getLocalizedMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/application/{applicationType}")
    public ResponseEntity
            <List<ApplicationDTO>> getIndividualOrganizationalUser(@PathVariable String applicationType){
        //String individualOrganizationalUser = applicationService.getIndividualOrganizationalUser(applicationType);
        List<ApplicationDTO> applicationDTOList = applicationService.getIndividualOrganizationalUser(applicationType);
        return ResponseEntity.ok(applicationDTOList);

    }
    @PutMapping("/application/{applicationType}/{applicationId}")
    public ResponseEntity<ApplicationDTO> updateApplicant(@PathVariable String applicationType, @PathVariable("applicationId") UUID applicantId,@RequestBody ApplicationDTO applicationDTO)
    {
        boolean updated = applicationService.updateApplicant(applicationType,applicantId,applicationDTO);
        if (updated) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/application/{applicationType}/{applicationId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String applicationType, @PathVariable("applicationId") UUID applicantId) {
        boolean deleted = applicationService.deleteApplicant(applicationType,applicantId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
