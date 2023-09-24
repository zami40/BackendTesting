package com.example.ekyc.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NidOcrResponseDTO {

    private String nid;
    private String dob;

}

