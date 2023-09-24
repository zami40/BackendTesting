//package com.example.ekyc.service;
//
//import com.example.ekyc.entity.FileData;
////import com.example.ekyc.entity.ImageData;
////import com.example.ekyc.respository.FileDataRepository;
////import com.example.ekyc.respository.StorageRepository;
////import com.example.ekyc.util.ImageUtils;
////import com.example.ekyc.repository.FileDataRepository;
//import com.example.ekyc.repository.FileDataRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class StorageService {
//
//
//    @Autowired
//    private FileDataRepository fileDataRepository;
//
//    private final String FOLDER_PATH="D:/Api 2(07-09-23)/";
//
//    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
////        UUID downloadImageFromFileSystemcumentId =
//        FileData fileData = new FileData();
//        String filePath=FOLDER_PATH+fileData.getDocumentId();
//
//        fileData=fileDataRepository.save(FileData.builder()
//                .documentLocation(filePath).build());
//
//        file.transferTo(new File(filePath));
//
//        if (fileData != null) {
//            return "file uploaded successfully : " + filePath;
//        }
//        return null;
//    }
//
////    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
////        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
////        String filePath=fileData.get().getFilePath();
////        byte[] images = Files.readAllBytes(new File(filePath).toPath());
////        return images;
////    }
//
//
//
//}
