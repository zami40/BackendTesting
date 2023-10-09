package com.example.ekyc.controller;
//import com.example.ekyc.DTO.NidOcrResponse;
import com.example.ekyc.DTO.NidOcrResponseDTO;
import com.example.ekyc.service.NidOcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/nid/ocr")
public class NidOcrController {
    @Autowired
    private NidOcrService nidOcrService;

    @PostMapping
    public ResponseEntity<NidOcrResponseDTO> performOcr(@RequestParam("file") MultipartFile imageFile) {
        try {
            // Convert MultipartFile to a temporary file
           // File tempImageFile = convert(imageFile);

            // Perform OCR using the service
            NidOcrResponseDTO response = nidOcrService.performOcr(imageFile);

            // Delete the temporary image file
            //tempImageFile.delete();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    private File convert(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        file.transferTo(convertedFile);
        return convertedFile;
    }
}
