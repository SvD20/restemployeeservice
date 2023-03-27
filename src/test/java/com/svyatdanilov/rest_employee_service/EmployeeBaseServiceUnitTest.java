package com.svyatdanilov.rest_employee_service;


import com.svyatdanilov.rest_employee_service.model.Employee;
import com.svyatdanilov.rest_employee_service.repository.CustomizedEmployeeJPARepository;
import com.svyatdanilov.rest_employee_service.service.EmployeeBaseServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeBaseServiceUnitTest {

    @Mock
    private CustomizedEmployeeJPARepository customizedEmployeeJPARepository;

    @InjectMocks
    private EmployeeBaseServiceImpl employeeService;

    @Test
    public void getAllEmployeesHappyFlow(){
        Iterable<Employee> allEmployees = employeeService.getAllObjects();
        Mockito.verify(customizedEmployeeJPARepository).findAll();
    }

    @Test
    public void getAEmployeeByIdHappyFlow(){
        int id = 1;
        Optional<Employee> employee = employeeService.getObject(id);
        Mockito.verify(customizedEmployeeJPARepository).findById(id);
    }


}
