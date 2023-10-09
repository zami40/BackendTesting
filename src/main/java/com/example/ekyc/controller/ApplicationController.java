package com.example.ekyc.controller;

import com.example.ekyc.DTO.ApplicationDTO;
import com.example.ekyc.DTO.ApplicationStatusDTO;
import com.example.ekyc.DTO.UserDTO;
import com.example.ekyc.entity.ApplicationStatusEntity;
import com.example.ekyc.entity.UserEntity;
import com.example.ekyc.service.ApplicationService;
import com.example.ekyc.service.UserService;
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
    private final UserService userService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, UserService userService){
        this.applicationService = applicationService;
        this.userService = userService;
    }
    @PostMapping("/application/{applicationType}/{UserId}")
    public ResponseEntity<UUID> addIndividualOrganizationalUser(@PathVariable String applicationType,@PathVariable UUID UserId, @RequestBody ApplicationDTO applicationDTO){
        UUID individualOrganizationalId = applicationService.addIndividualOrganizationalUser(applicationType,applicationDTO);
        applicationService.addApplicationStatusTbl(applicationType,individualOrganizationalId,UserId);
        if(individualOrganizationalId != null){
            return ResponseEntity.ok(individualOrganizationalId);
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
    public ResponseEntity<List<ApplicationDTO>> getIndividualOrganizationalUser(@PathVariable String applicationType){
        //String individualOrganizationalUser = applicationService.getIndividualOrganizationalUser(applicationType);
        List<ApplicationDTO> applicationDTOList = applicationService.getIndividualOrganizationalUser(applicationType);
        return ResponseEntity.ok(applicationDTOList);

    }
    @GetMapping("/application/status")
    public ResponseEntity<List<ApplicationStatusDTO>> getAllStatus(){
        List<ApplicationStatusDTO> applictionStatusDTO = applicationService.getAllStatus();
        return ResponseEntity.ok(applictionStatusDTO);
    }

    @GetMapping("/application/status/{userID}")
    public ResponseEntity<List<ApplicationStatusDTO>> getAllStatusById(@PathVariable UUID userID){
//        UserEntity userEntity = userRepository.
        // UserDTO userDTO = userService.getUserById(userID);

        if(userID != null){
            List<ApplicationStatusDTO> applictionStatusDTO = applicationService.getAllStatusById(userID);
            return ResponseEntity.ok(applictionStatusDTO);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/application/{applicationType}/{applicationId}/{UserId}")
    public ResponseEntity<ApplicationDTO> updateApplicant(@PathVariable String applicationType, @PathVariable("applicationId") UUID applicantId,@RequestBody ApplicationDTO applicationDTO)
    {
        boolean updated = applicationService.updateApplicant(applicationType,applicantId,applicationDTO);
        if (updated) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/application/{applicationType}/{applicationId}/{UserId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String applicationType, @PathVariable("applicationId") UUID applicantId) throws Exception {
        try{
            String deleted = applicationService.deleteApplicant(applicationType,applicantId);
            if (deleted.equals("true")) {
                return ResponseEntity.noContent().build();
//            return ResponseEntity.status(HttpStatus.OK).body();
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            throw new Exception("Applicant Id Does Not Exist");
        }
    }
}