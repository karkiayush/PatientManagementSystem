package com.pms.patientservice.exception;

public class DeletePatientFailedException extends RuntimeException {
    public DeletePatientFailedException(String message) {
        super(message);
    }
}
