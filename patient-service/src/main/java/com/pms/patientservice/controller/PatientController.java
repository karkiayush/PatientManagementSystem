package com.pms.patientservice.controller;

import com.pms.patientservice.dto.PatientResponseDTO;
import com.pms.patientservice.model.Patient;
import com.pms.patientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /*CREATE operation*/
    @PostMapping
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody Patient patient) {
        /*patientService.addPatient(patient);*/
        return null;
    }

    /*READ all operation*/
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(patients);
    }

    /*READ operation*/
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable UUID id) {
        Optional<PatientResponseDTO> patientDto = Optional.ofNullable(patientService.getPatientById(id));
        return patientDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*UPDATE operation*/


    /*DELETE operation*/
}
