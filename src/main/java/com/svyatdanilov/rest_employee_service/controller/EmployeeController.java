package com.svyatdanilov.rest_employee_service.controller;

import com.svyatdanilov.rest_employee_service.model.Employee;
import com.svyatdanilov.rest_employee_service.service.EmployeeBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeBaseServiceImpl employeeService;

    @GetMapping
    public Iterable<Employee> getAllEmployees(){
        return employeeService.getAllObjects();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/name")
    public Iterable<Employee> getAllEmployeesByName(@RequestParam String name){
        return employeeService.getAllEmployeesByName(name);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/surname")
    public Iterable<Employee> getAllEmployeesBySurname(@RequestParam String surname){
        return employeeService.getAllEmployeesBySurname(surname);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/department")
    public Iterable<Employee> getAllEmployeesByDepartment(@RequestParam String department){
        return employeeService.getAllEmployeesByDepartment(department);
    }

    @GetMapping("/maximum_salary")
    public Iterable<Employee> getAllEmployeesWithSalaryLessThan(@RequestParam int salary){
        return employeeService.getAllEmployeesWithSalaryLessThan(salary);
    }

    @GetMapping("/minimum_salary")
    public Iterable<Employee> getAllEmployeesWithSalaryMoreThan(@RequestParam int salary){
        return employeeService.getAllEmployeesWithSalaryMoreThan(salary);
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
