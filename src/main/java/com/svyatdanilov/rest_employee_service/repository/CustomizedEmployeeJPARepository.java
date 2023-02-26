package com.svyatdanilov.rest_employee_service.repository;

import com.svyatdanilov.rest_employee_service.dto_entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedEmployeeJPARepository extends BaseRepository<Employee,Integer> {
}
