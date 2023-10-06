package com.example.ekyc.controller;

import com.example.ekyc.DTO.DocumentDTO;
import com.example.ekyc.DTO.DocumentDTO;
import com.example.ekyc.DTO.DocumentIdDTO;
import com.example.ekyc.service.DocumentService;
import com.example.ekyc.service.DocumentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/document")
    public ResponseEntity<DocumentIdDTO> uploadImageToFIleSystem(@ModelAttribute DocumentDTO dto) throws IOException {
        DocumentIdDTO documentIdDTO = documentService.uploadImageToFileSystem(dto.getFile());
        return ResponseEntity.status(HttpStatus.OK)
                .body(documentIdDTO);
    }

    @GetMapping("/document/{documentId}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable UUID documentId) throws IOException {
        try {
            byte[] fileBytes = documentService.downloadImageFromFileSystem(documentId);
            if(fileBytes!=null) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileBytes);
            }
            else{
                return ResponseEntity.badRequest().body("Does not exist");
            }
        }catch (Exception e){
            throw new RuntimeException("Error while downloading image from the file system: " + e.getMessage(), e);
        }


    }

    @PutMapping("/document/{documentId}")
    public ResponseEntity<String> updateImageInFileSystem(@PathVariable UUID documentId, @ModelAttribute DocumentDTO dto) throws IOException {
        String updateResult = documentService.updateImageInFileSystem(documentId, dto.getFile());
        return ResponseEntity.status(HttpStatus.OK).body(updateResult);
    }

    @DeleteMapping("/document/{documentId}")
    public ResponseEntity<String> deleteImageFromFileSystem(@PathVariable UUID documentId) {
        try {

                String deleteResult = documentService.deleteImageFromFileSystem(documentId);
            if(deleteResult.equals("File not found")) {

                return ResponseEntity.notFound().build();
            }else {
                return ResponseEntity.status(HttpStatus.OK).body(deleteResult);
            }
        }
        catch (Exception e)
        {
            return null;
        }

    }
}

