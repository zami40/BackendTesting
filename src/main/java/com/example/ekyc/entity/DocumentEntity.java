package com.example.ekyc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOCUMENT_TBL")
public class DocumentEntity {

    @Id
    private UUID documentId;
    private String documentLocation;
}
