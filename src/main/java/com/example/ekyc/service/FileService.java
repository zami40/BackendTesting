//package com.example.ekyc.service;
//
//import com.example.ekyc.DTO.FileDTO;
//import com.example.ekyc.entity.FileEntity;
//import com.example.ekyc.repository.FileRepository;
//import com.example.ekyc.repository.UserRepository;
////import jakarta.annotation.Resource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.UUID;
//
//@Service
//public class FileService {
//    private FileRepository fileRepository;
//    @Autowired
//    public FileService(FileRepository fileRepository) {
//        this.fileRepository = fileRepository;
//    }
//    @Value("${upload.dir}")
//    private String uploadDir;
//
//    public FileDTO uploadFile(MultipartFile file) throws IOException {
//        String fileId = UUID.randomUUID().toString();
//        String filePath = uploadDir + "/" + fileId;
//
//        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
//
//        FileEntity fileEntity = new FileEntity();
//        fileEntity.setFileId(fileId);
//        fileEntity.setFileName(file.getOriginalFilename());
//
//        fileRepository.save(fileEntity);
//
//        FileDTO fileDTO = new FileDTO();
//        fileDTO.setFileId(fileId);
//
//        return fileDTO;
//    }
//
//
//    public Resource downloadFile(String fileId) throws FileNotFoundException {
//        String filePath = uploadDir + "/" + fileId;
//        Path path = Paths.get(filePath);
//
//        try {
//            Resource resource = new UrlResource(path.toUri());
//
//            if (resource.exists() && resource.isReadable()) {
//                return resource;
//            } else {
//                throw new FileNotFoundException("File not found or cannot be read: " + filePath);
//            }
//        } catch (MalformedURLException e) {
//            throw new FileNotFoundException("File not found: " + filePath);
//        }
//    }
//}
