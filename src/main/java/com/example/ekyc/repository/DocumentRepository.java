package com.example.ekyc.repository;

import com.example.ekyc.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {
    //Optional<FileData> findByName(String fileName);
}