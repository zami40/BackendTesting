package com.example.ekyc.repository;

import com.example.ekyc.entity.IndividualApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IndividualApplicationRepository extends JpaRepository<IndividualApplicationEntity, UUID> {
}
