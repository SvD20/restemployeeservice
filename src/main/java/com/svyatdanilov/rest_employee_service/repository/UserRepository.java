package com.svyatdanilov.rest_employee_service.repository;

import com.svyatdanilov.rest_employee_service.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
       Optional<User> findByUsername(String Username);
}
