package com.pms.patientservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /*This will handle any of the validation errors which gets triggered when the jpa validates the request dto in request*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
                error -> errorMap.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errorMap);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        // using slf4j logger to log the error message
        log.warn("Email already exists{}", e.getMessage());
        Map<String, String> emailExistsErrorMap = new HashMap<>();
        emailExistsErrorMap.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(emailExistsErrorMap);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFound(PatientNotFoundException e) {
        log.warn("Patient not found: {}", e.getMessage());
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(errorMap);
    }

    @ExceptionHandler(UpdatePatientFailedException.class)
    public ResponseEntity<Map<String, String>> handleUpdatePatientFailed(UpdatePatientFailedException e) {
        log.warn("Update patient failed: {}", e.getMessage());
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(errorMap);
    }

    @ExceptionHandler(DeletePatientFailedException.class)
    public ResponseEntity<Map<String, String>> handleDeletePatientFailed(DeletePatientFailedException e) {
        log.warn("Delete patient failed: {}", e.getMessage());
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(errorMap);
    }
}
