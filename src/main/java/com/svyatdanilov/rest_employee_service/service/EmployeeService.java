package com.svyatdanilov.rest_employee_service.service;

import com.svyatdanilov.rest_employee_service.dto_entity.Employee;

public interface EmployeeService {

    Iterable<Employee> getAllEmployeesByName(String name);
    Iterable<Employee> getAllEmployeesBySurname(String surname);
    Iterable<Employee> getAllEmployeesByDepartment(String department);
    Iterable<Employee> getAllEmployeesWithSalaryLessThan(int salary);
    Iterable<Employee> getAllEmployeesWithSalaryMoreThan(int salary);
}
