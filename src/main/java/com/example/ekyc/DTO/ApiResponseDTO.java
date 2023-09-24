package com.example.ekyc.DTO;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDTO {
    String code;
    String message;
    String nid;
    String name;
    String nameBan;
    String father;
    String mother;
    String presentAddress;
    String permanentAddress;
    String dob;
    String gender;
    String photo;


}
