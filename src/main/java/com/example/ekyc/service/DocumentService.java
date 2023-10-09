package com.example.ekyc.service;

import com.example.ekyc.DTO.DocumentIdDTO;
import com.example.ekyc.entity.DocumentEntity;
import com.example.ekyc.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentService {


    @Autowired
    private DocumentRepository documentRepository;
    @Value("${folder.path}")
    private String FOLDER_PATH;
    //private final String FOLDER_PATH="D:\\TestImage\\NID_Cropped\\file_uploaded\\";

    public DocumentIdDTO uploadFileToFileSystem(MultipartFile file) throws IOException {
        DocumentEntity documentEntity = new DocumentEntity();

        UUID documentId = UUID.randomUUID();
        String filePath = FOLDER_PATH + documentId + getFileExtension(file.getOriginalFilename());
        documentEntity.setDocumentId(documentId);
        documentEntity.setDocumentLocation(filePath);

        documentEntity = documentRepository.save(documentEntity);
        //System.out.println("File path: " + filePath);
        file.transferTo(new File(filePath));

        if (documentEntity != null) {
            DocumentIdDTO documentIdDTO = new DocumentIdDTO();
            documentIdDTO.setDocumentId(documentId);
            return documentIdDTO;
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex);
    }


    public ResponseEntity<?> downloadFileFromFileSystem(UUID documentId) throws IOException {
        Optional<DocumentEntity> optionalFileData = documentRepository.findById(documentId);

        if (optionalFileData.isPresent()) {
            DocumentEntity document = optionalFileData.get();
            String filePath = document.getDocumentLocation();
            File file = new File(filePath);

            if (file.exists()) {
                byte[] fileBytes = Files.readAllBytes(file.toPath());

                // Set appropriate headers for download
                HttpHeaders headers = new HttpHeaders();
                headers.setContentDisposition(ContentDisposition.builder("attachment")
                        .filename(file.getName())
                        .build());
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(fileBytes);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
        }
    }


    public DocumentIdDTO updateFileInFileSystem(UUID documentId, MultipartFile file) throws IOException, FileNotFoundException {
        Optional<DocumentEntity> optionalDocument = documentRepository.findById(documentId);
        if (optionalDocument.isPresent()) {
            DocumentEntity documentEntity = optionalDocument.get();
            String filePath = documentEntity.getDocumentLocation();
            file.transferTo(new File(filePath));

                DocumentIdDTO documentIdDTO = new DocumentIdDTO();
                documentIdDTO.setDocumentId(documentId);
                return documentIdDTO;

        } else {
            throw new FileNotFoundException("File not found");
        }
    }


    public DocumentIdDTO deleteFileFromFileSystem(UUID documentId) throws FileNotFoundException {
        Optional<DocumentEntity> optionalFileData = documentRepository.findById(documentId);
        if (optionalFileData.isPresent()) {
            DocumentEntity documentEntity = optionalFileData.get();
            String filePath = documentEntity.getDocumentLocation();
            File file = new File(filePath);
            if (file.delete()) {
                documentRepository.deleteById(documentId);
                DocumentIdDTO documentIdDTO = new DocumentIdDTO();
                documentIdDTO.setDocumentId(documentId);
                return documentIdDTO;
            } else {
                return null;
            }
        } else {
            throw new FileNotFoundException("File not found");
        }
    }




}
