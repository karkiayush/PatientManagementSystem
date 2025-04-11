package com.pms.patientservice.dto;

import lombok.Data;

@Data
public class PatientResponseDTO {
    private String id;
    private String patientName;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
}
