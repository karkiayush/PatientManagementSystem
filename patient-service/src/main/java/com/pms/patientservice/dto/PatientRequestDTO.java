package com.pms.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
    @NotBlank
    @Size(max = 50, message = "Name can't exceed 50 characters")
    private String firstName;

    @NotBlank
    @Size(max = 50, message = "Name can't exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Email address is required")
    @Email(message = "Email address should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address can't exceed 255 characters")
    private String address;

    @NotBlank(message = "Patient gender is required")
    @Size(max = 25, message = "Gender must be less than 25 characters")
    private String gender;

    @NotBlank(message = "Date of birth is required")
    @Size(max = 15, message = "DOB must be with in 15 characters")
    private String dateOfBirth;

    @NotBlank(message = "Phone number is required")
    @Size(max = 15, message = "Phone number must be less than 15 characters")
    private String phoneNumber;

    @NotBlank(message = "Registration date is required")
    @Size(max = 15, message = "Registration date must be with in 15 characters")
    private String registrationDate;
    /*
    *
    * private String id;
    private String patientName;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    * */
}
