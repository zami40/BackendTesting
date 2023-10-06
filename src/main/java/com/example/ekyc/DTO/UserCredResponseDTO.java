package com.example.ekyc.DTO;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredResponseDTO {
    private UUID userId;
    private String role;

    public UserCredResponseDTO(String invalidCredentials) {
    }
}
