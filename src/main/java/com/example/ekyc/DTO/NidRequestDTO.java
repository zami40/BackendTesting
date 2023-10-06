package com.example.ekyc.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NidRequestDTO {
    private String username;
    private String password;
    private String nid;
    private String dob;
}
