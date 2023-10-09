package com.example.ekyc.repository;

import com.example.ekyc.entity.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCredRepository extends JpaRepository<UserCredentialEntity, UUID> {
    UserCredentialEntity findByUserName(String userName);
}