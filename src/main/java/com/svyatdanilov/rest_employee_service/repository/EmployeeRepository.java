package com.svyatdanilov.rest_employee_service.repository;

import com.svyatdanilov.rest_employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Iterable<Employee> findAllByName(String name);
    Iterable<Employee> findAllBySurname(String surname);
    Iterable<Employee> findAllByDepartment(String department);
    Iterable<Employee> findDistinctBySalaryIsLessThan(int salary);
    Iterable<Employee> findDistinctBySalaryIsGreaterThan(int salary);

}
