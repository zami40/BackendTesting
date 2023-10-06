package com.example.ekyc.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
    public class DocumentDTO {
        private MultipartFile file;
    }

