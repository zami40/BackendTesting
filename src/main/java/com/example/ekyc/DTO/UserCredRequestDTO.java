package com.example.ekyc.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredRequestDTO {
    private String userName;
    private String password;
}