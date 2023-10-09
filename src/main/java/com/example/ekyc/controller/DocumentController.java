package com.example.ekyc.controller;

//import com.example.ekyc.DTO.DocumentDTO;
import com.example.ekyc.DTO.DocumentIdDTO;
import com.example.ekyc.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/document")
    public ResponseEntity<DocumentIdDTO> uploadFileToFIleSystem(@RequestParam("file") MultipartFile file) throws IOException {
        DocumentIdDTO documentIdDTO = documentService.uploadFileToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(documentIdDTO);
    }

    @GetMapping("/document/{documentId}")
    public ResponseEntity<?> downloadFileFromFileSystem(@PathVariable UUID documentId) throws IOException {
        try {
            return documentService.downloadFileFromFileSystem(documentId);
        } catch (Exception e) {
            throw new RuntimeException("Error while downloading file from the file system: " + e.getMessage(), e);
        }
    }


    @PutMapping("/document/{documentId}")
    public ResponseEntity<?> updateFileInFileSystem(@PathVariable UUID documentId, @RequestParam("file") MultipartFile file) {
        try {
            DocumentIdDTO updateResult = documentService.updateFileInFileSystem(documentId, file);
            return ResponseEntity.status(HttpStatus.OK).body(updateResult);
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update file: " + e.getMessage());
        }
    }

    @DeleteMapping("/document/{documentId}")
    public ResponseEntity<?> deleteFileFromFileSystem(@PathVariable UUID documentId) {
        try {
            DocumentIdDTO deleteResult = documentService.deleteFileFromFileSystem(documentId);
            return ResponseEntity.status(HttpStatus.OK).body(deleteResult);
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete file: " + e.getMessage());
        }
    }



}

