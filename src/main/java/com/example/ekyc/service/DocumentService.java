package com.example.ekyc.service;

import com.example.ekyc.entity.DocumentEntity;
import com.example.ekyc.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final String FOLDER_PATH="F:\\ZamiEtc\\OcrTest\\src\\main\\resources\\NID_Cropped\\api2Test\\";

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        DocumentEntity documentEntity = new DocumentEntity();

        UUID documentId = UUID.randomUUID();
        String filePath = FOLDER_PATH + documentId;

        documentEntity.setDocumentId(documentId);  // Set the UUID
        documentEntity.setDocumentLocation(filePath);

        documentEntity = documentRepository.save(documentEntity);
        System.out.println("File path: " + filePath);
        file.transferTo(new File(filePath));

        if (documentEntity != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(UUID documentId) throws IOException {
        Optional<DocumentEntity> optionalFileData = documentRepository.findById(documentId);
        if (optionalFileData.isPresent()) {
            String filePath = optionalFileData.get().getDocumentLocation();
            return Files.readAllBytes(new File(filePath).toPath());
        } else {
            throw new FileNotFoundException("File not found");
        }
    }

    public String updateImageInFileSystem(UUID documentId, MultipartFile file) throws IOException, FileNotFoundException {
        Optional<DocumentEntity> optionalDocument = documentRepository.findById(documentId);
        if (optionalDocument.isPresent()) {
            DocumentEntity documentEntity = optionalDocument.get();
            String filePath = documentEntity.getDocumentLocation();
            file.transferTo(new File(filePath));
            return "File updated successfully: " + filePath;
        } else {
            throw new FileNotFoundException("File not found");
        }
    }

    public String deleteImageFromFileSystem(UUID documentId) throws FileNotFoundException {
        Optional<DocumentEntity> optionalFileData = documentRepository.findById(documentId);
        if (optionalFileData.isPresent()) {
            DocumentEntity documentEntity = optionalFileData.get();
            String filePath = documentEntity.getDocumentLocation();
            File file = new File(filePath);
            if (file.delete()) {
                documentRepository.deleteById(documentId);
                return "File deleted successfully: " + filePath;
            } else {
                return "Failed to delete file.";
            }
        } else {
            throw new FileNotFoundException("File not found");
        }
    }



}
