package com.pms.patientservice.service;

import com.pms.patientservice.dto.PatientResponseDTO;
import com.pms.patientservice.model.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    public PatientResponseDTO createPatient(Patient patient);
    public List<PatientResponseDTO> getPatients();
    public PatientResponseDTO getPatientById(UUID id);
}
