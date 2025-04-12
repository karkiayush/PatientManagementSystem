package com.pms.patientservice.controller;

import com.pms.patientservice.dto.PatientRequestDTO;
import com.pms.patientservice.dto.PatientResponseDTO;
import com.pms.patientservice.repository.PatientRepository;
import com.pms.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "API for managing patients")
public class PatientController {
    private final PatientService patientService;
    private final PatientRepository patientRepository;

    public PatientController(PatientService patientService, PatientRepository patientRepository) {
        this.patientService = patientService;
        this.patientRepository = patientRepository;
    }

    /*CREATE operation*/
    @PostMapping
    @Operation(summary = "Create a new patient", method = "POST")
    public ResponseEntity<PatientResponseDTO> addPatient(
            /*valid annotation ensures that based on the check case we applied to the PatientRequestDTO, it ensures those are satisfied else it will provide error message*/
            @Valid
            // converts the JSON request to the PatientRequestDTO object
            @RequestBody
            PatientRequestDTO patientRequestDTO
    ) {
        PatientResponseDTO createdPatient = patientService.createPatient(patientRequestDTO);
        if (createdPatient == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdPatient);
    }

    /*READ all operation*/
    @GetMapping
    @Operation(summary = "Get all patients", method = "GET")

    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(patients);
    }

    /*READ operation*/
    @GetMapping("/{id}")
    @Operation(summary = "Get a patient by ID", method = "GET")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable UUID id) {
        Optional<PatientResponseDTO> patientDto = Optional.ofNullable(patientService.getPatientById(id));
        return patientDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*UPDATE operation*/
    @PutMapping("/{id}")
    @Operation(summary = "Update a patient by ID", method = "PUT")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @RequestBody PatientRequestDTO patientRequestDTO) {
        Optional<PatientResponseDTO> patient = Optional.ofNullable(patientService.updatePatient(id, patientRequestDTO));
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*DELETE operation*/
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient by ID", method = "DELETE")
    public ResponseEntity<PatientResponseDTO> deletePatient(@PathVariable UUID id) {
        Optional<PatientResponseDTO> deletedPatient = Optional.ofNullable(patientService.deletePatient(id));
        return deletedPatient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
