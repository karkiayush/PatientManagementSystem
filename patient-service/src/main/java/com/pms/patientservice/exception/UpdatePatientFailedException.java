package com.pms.patientservice.exception;

public class UpdatePatientFailedException extends RuntimeException {
  public UpdatePatientFailedException(String message) {
    super(message);
  }
}
