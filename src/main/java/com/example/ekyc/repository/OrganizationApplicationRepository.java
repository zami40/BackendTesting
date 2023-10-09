package com.example.ekyc.repository;

import com.example.ekyc.entity.OrganizationApplicationEntity;
import com.example.ekyc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationApplicationRepository extends JpaRepository<OrganizationApplicationEntity, UUID> {
}
