package com.svyatdanilov.rest_employee_service.customexception;

public class EmployeeNotFoundException extends RuntimeException{

    private static final long serialVersionUID =1L;

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
