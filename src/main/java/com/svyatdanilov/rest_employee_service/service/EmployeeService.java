package com.svyatdanilov.rest_employee_service.service;

import com.svyatdanilov.rest_employee_service.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    public EmployeeService(EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
    }


}
