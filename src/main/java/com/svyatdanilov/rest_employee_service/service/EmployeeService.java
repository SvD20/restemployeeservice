package com.svyatdanilov.rest_employee_service.service;

import com.svyatdanilov.rest_employee_service.dto_entity.Employee;
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
    public Optional<Employee> getObject(int id) {
        return customizedEmployeeJPARepository.findById(id);
    }

    @Override
    public void deleteObject(int id) {
       customizedEmployeeJPARepository.deleteById(id);
    }
}
