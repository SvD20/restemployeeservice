package com.svyatdanilov.rest_employee_service;


import com.svyatdanilov.rest_employee_service.dto_entity.Employee;
import com.svyatdanilov.rest_employee_service.repository.CustomizedEmployeeJPARepository;
import com.svyatdanilov.rest_employee_service.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceUnitTest {

    @Mock
    private CustomizedEmployeeJPARepository customizedEmployeeJPARepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void getAllEmployeesHappyFlow(){
        Iterable<Employee> allEmployees = employeeService.getAllObjects();
        Mockito.verify(customizedEmployeeJPARepository).findAll();
    }

    @Test
    public void getAEmployeeByIdHappyFlow(){
        int id = 1;
        Optional<Employee> employee = employeeService.getObject(id);
        Mockito.verify(customizedEmployeeJPARepository).deleteById(id);
    }


}
