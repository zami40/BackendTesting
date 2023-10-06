package com.example.ekyc.repository;

import com.example.ekyc.entity.ApplicationStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatusEntity, UUID> {
    //Optional<FileData> findByName(String fileName);
    List<ApplicationStatusEntity> findAllByUserID(UUID userId);
}
