package com.svyatdanilov.rest_employee_service.controller;

import com.svyatdanilov.rest_employee_service.dto_entity.Employee;
import com.svyatdanilov.rest_employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Iterable<Employee> getAllEmployees(){
        return employeeService.getAllObjects();
    }

    @GetMapping("{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        return employeeService.getObject(id);
    }

    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.saveObject(employee);
    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable int id,
                                   @RequestBody Employee employee){
        employeeService.updateObject(id,employee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeById(@PathVariable int id){
        employeeService.deleteObject(id);
    }

}
