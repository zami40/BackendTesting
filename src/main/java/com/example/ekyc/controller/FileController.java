//package com.example.ekyc.controller;
//
//import com.example.ekyc.DTO.FileDTO;
//import com.example.ekyc.service.FileService;
////import jakarta.annotation.Resource;
//import org.springframework.core.io.Resource;
////import org.springframework.core.io.UrlResource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/files")
//public class FileController {
//    @Autowired
//    private FileService fileService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<FileDTO> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        try {
//            FileDTO fileDTO = fileService.uploadFile(file);
//            return ResponseEntity.ok(fileDTO);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping("/download/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
//        try {
//            Resource resource = fileService.downloadFile(fileId);
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .body(resource);
//        } catch (FileNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//}
