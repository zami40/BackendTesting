package com.example.ekyc.service;

import com.example.ekyc.DTO.ApiResponseDTO;
import com.example.ekyc.DTO.NidRequestDTO;

import com.example.ekyc.DTO.NidResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NidService {

    private final RestTemplate restTemplate;

    @Autowired
    public NidService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NidResponseDTO postToExternalApi(String apiUrl, NidRequestDTO requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        apiUrl = apiUrl.trim();

        HttpEntity<NidRequestDTO> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<NidResponseDTO> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                request,
                NidResponseDTO.class);

        return responseEntity.getBody();
    }
}

