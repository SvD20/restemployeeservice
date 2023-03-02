package com.svyatdanilov.rest_employee_service.service;

import com.svyatdanilov.rest_employee_service.dto_entity.Employee;
import com.svyatdanilov.rest_employee_service.customexception.EmployeeNotFoundException;
import com.svyatdanilov.rest_employee_service.repository.CustomizedEmployeeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@org.springframework.stereotype.Service
public class EmployeeService implements Service<Employee>{

    @Autowired
    private CustomizedEmployeeJPARepository customizedEmployeeJPARepository;

    @Override
    public Iterable<Employee> getAllObjects() {
        return customizedEmployeeJPARepository.findAll();
    }

    @Override
    public Employee saveObject(Employee obj) {
        return customizedEmployeeJPARepository.save(obj);
    }

    @Override
    public Employee updateObject(int id, Employee object) {
        Employee updatedEmployee = customizedEmployeeJPARepository.findById(id).orElseThrow(()->
                new EmployeeNotFoundException(
                String.format("No employee with id %s is available", id)));

            updatedEmployee.setName(object.getName());
            updatedEmployee.setSurname(object.getSurname());
            updatedEmployee.setDepartment(object.getDepartment());
            updatedEmployee.setSalary(object.getSalary());

            return customizedEmployeeJPARepository.save(updatedEmployee);
    }

    @Override
    public Optional<Employee> getObject(int id) {
        return customizedEmployeeJPARepository.findById(id);
    }

    @Override
    public void deleteObject(int id) {
        customizedEmployeeJPARepository.findById(id).orElseThrow(()->
                new EmployeeNotFoundException(
                        String.format("No employee with id %s is available", id)));
       customizedEmployeeJPARepository.deleteById(id);
    }
}
