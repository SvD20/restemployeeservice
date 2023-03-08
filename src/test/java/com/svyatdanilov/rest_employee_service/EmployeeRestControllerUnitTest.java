package com.svyatdanilov.rest_employee_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svyatdanilov.rest_employee_service.controller.EmployeeController;
import com.svyatdanilov.rest_employee_service.dto_entity.Employee;
import com.svyatdanilov.rest_employee_service.service.EmployeeBaseServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class EmployeeRestControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeBaseServiceImpl employeeServiceImpl;

    @Test
    public void getAllEmployeesHappyFlow() throws Exception {
        Employee testEmployee = new Employee("test","test","test",1);

        List<Employee> allEmployees = Arrays.asList(testEmployee);

        Mockito.when(employeeServiceImpl.getAllObjects()).thenReturn(allEmployees);

        mvc.perform(get("/employees/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(testEmployee.getName())));
    }

    @Test
    public void getEmployeeByIdHappyFlow() throws Exception {
        Employee testEmployee = new Employee("test","test","test",1);
        final int id = 1;
        testEmployee.setId(id);

        Mockito.when(employeeServiceImpl.getObject(id)).thenReturn(Optional.of(testEmployee));

        mvc.perform(get("/employees/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.department").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(1));
    }

    @Test
    public void addEmployeeHappyFlow() throws Exception {
        Employee sendingEmployee = new Employee("test","test","test",1);

        mvc.perform(post("/employees/").content(objectMapper.writeValueAsString(sendingEmployee))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }




}
