package com.svyatdanilov.rest_employee_service;

import com.svyatdanilov.rest_employee_service.dto_entity.Employee;
import com.svyatdanilov.rest_employee_service.repository.CustomizedEmployeeJPARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomizedEmployeeJPARepositoryUnitTest {

    @Autowired
    private CustomizedEmployeeJPARepository customizedEmployeeRepository;

    @Test
    public void givenCreateWhenFindAllEmployeesThenExpectOneEmployee(){
        Employee employee = new Employee("test","test", "test", 111);
        customizedEmployeeRepository.save(employee);
        assertThat(customizedEmployeeRepository.findAll()).hasSize(8);

    }


}
