package com.pms.patientservice.service;

import com.pms.patientservice.dto.PatientRequestDTO;
import com.pms.patientservice.dto.PatientResponseDTO;
import com.pms.patientservice.exception.EmailAlreadyExistsException;
import com.pms.patientservice.exception.PatientNotFoundException;
import com.pms.patientservice.exception.UpdatePatientFailedException;
import com.pms.patientservice.mapper.PatientMapper;
import com.pms.patientservice.model.Patient;
import com.pms.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;


@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists" + patientRequestDTO.getEmail());
        }
        try {
            Patient patient = PatientMapper.toPatientModel(patientRequestDTO);
            Patient returnedPatient = patientRepository.save(patient);
            return PatientMapper.toPatientResponseDto(returnedPatient);
        } catch (Exception e) {
            System.out.println("Failed to save patient: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        /*converting the Patient domain entity object to PatientResponseDTO object & then returning*/
        return patients.stream().map(PatientMapper::toPatientResponseDto).toList();
    }

    @Override
    public PatientResponseDTO getPatientById(UUID id) {
        /*
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            return PatientMapper.toPatientResponseDto(patient.get());
        } else {
            System.out.println("Patient not found with id: " + id);
            return null;
        }*/
        return patientRepository.findById(id).map(PatientMapper::toPatientResponseDto).orElse(null);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with id: " + id)
        );

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists" + patientRequestDTO.getEmail());
        }
        patient.setFullName(patientRequestDTO.getFullName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setGender(patientRequestDTO.getGender());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegistrationDate(LocalDate.parse(patientRequestDTO.getRegistrationDate()));
        patient.setPhoneNumber(String.valueOf(patientRequestDTO.getPhoneNumber()));

        LocalDate dob = LocalDate.parse(patientRequestDTO.getDateOfBirth());
        int age = Period.between(dob, LocalDate.now()).getYears();
        patient.setAge(age);
        try {
            Patient updatedPatient = patientRepository.save(patient);
            return PatientMapper.toPatientResponseDto(updatedPatient);
        } catch (Exception e) {
            throw new UpdatePatientFailedException("Failed to update patient: " + e.getMessage());
        }
    }
}
