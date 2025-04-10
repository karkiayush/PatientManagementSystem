package com.pms.patientservice.controller;

import com.pms.patientservice.dto.PatientResponseDTO;
import com.pms.patientservice.model.Patient;
import com.pms.patientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody Patient patient) {
        /*patientService.addPatient(patient);*/

        return null;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok(patients);
    }
}
