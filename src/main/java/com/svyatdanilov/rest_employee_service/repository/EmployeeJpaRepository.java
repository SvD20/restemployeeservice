package com.svyatdanilov.rest_employee_service.repository;

import com.svyatdanilov.rest_employee_service.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {
}
