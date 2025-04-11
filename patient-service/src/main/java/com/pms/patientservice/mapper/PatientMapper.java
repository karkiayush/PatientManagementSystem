package com.pms.patientservice.mapper;

import com.pms.patientservice.dto.PatientRequestDTO;
import com.pms.patientservice.dto.PatientResponseDTO;
import com.pms.patientservice.model.Patient;

import java.time.LocalDate;
import java.time.Period;

public class PatientMapper {
    public static PatientResponseDTO toPatientResponseDto(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setPatientName(patient.getFirstName() + " " + patient.getLastName());
        patientResponseDTO.setGender(patient.getGender());
        patientResponseDTO.setDateOfBirth(patient.getBirthDate().toString());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setPhoneNumber(patient.getPhoneNumber());
        patientResponseDTO.setAddress(patient.getAddress());

        return patientResponseDTO;
    }

    public static Patient toPatientModel(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();

        /*Calculating age*/
        LocalDate dob = LocalDate.parse(patientRequestDTO.getDateOfBirth());
        int age = Period.between(dob, LocalDate.now()).getYears();

        patient.setFirstName(patientRequestDTO.getFirstName());
        patient.setLastName(patientRequestDTO.getLastName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setAge(age);
        patient.setGender(patientRequestDTO.getGender());
        patient.setPhoneNumber(patientRequestDTO.getPhoneNumber());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setRegistrationDate(LocalDate.parse(patientRequestDTO.getRegistrationDate()));

        return patient;
    }
}
