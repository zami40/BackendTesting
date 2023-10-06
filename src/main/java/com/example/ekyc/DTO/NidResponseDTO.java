package com.example.ekyc.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NidResponseDTO {
    //just uncomment the fields and response will show that fields also
    private int code;
    private String message;
    private String nid;
    private String name;
//    private String nameBan;
    private String father;
    private String mother;
//    private String presentAddress;
//    private String permanentAddress;
    private String dob;
//    private String gender;
//    private byte[] photo;
}
