package com.example.ekyc.controller;

import com.example.ekyc.DTO.*;
import com.example.ekyc.service.NidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/api")
public class NidFetchController {

    private final NidService nidService;

    @Autowired
    public NidFetchController(NidService nidService) {
        this.nidService = nidService;
    }

    @PostMapping("/nid/fetch")
    public ResponseEntity<NidResponseDTO> getNidInfo(@RequestBody NidInputDTO nidInputDTO) {
        NidRequestDTO nidRequestDTO = new NidRequestDTO();
        nidRequestDTO.setUsername("Farhana.Nid");
        nidRequestDTO.setPassword("Farhana#2018@Nid");
        nidRequestDTO.setNid(nidInputDTO.getNid());
        nidRequestDTO.setDob(nidInputDTO.getDob());
        String apiUrl = "http://202.84.43.87:80/api-v1/getNIDInfo/";
//            ApiResponseDTO apiResponseDTO = NidService.postToExternalApi(apiUrl, nidRequestDTO);
        return ResponseEntity.ok(nidService.postToExternalApi(apiUrl, nidRequestDTO));
    }
}
