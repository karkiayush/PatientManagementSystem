package com.pms.patientservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResponseDTO {
    private String id;
    private String patientName;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
}
