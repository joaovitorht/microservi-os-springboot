package com.devsuperior.hr_payroll.feignclients;

public class WorkerServiceUnavailableException extends RuntimeException {
    public WorkerServiceUnavailableException(String message) {
        super(message);
    }
}
