package com.pms.patientservice.mapper;

import com.pms.patientservice.dto.PatientResponseDTO;
import com.pms.patientservice.model.Patient;

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
}
