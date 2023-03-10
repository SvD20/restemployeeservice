package com.svyatdanilov.rest_employee_service.service;

import java.util.List;
import java.util.Optional;

public interface Service <T> {

    Iterable<T> getAllObjects();

    T saveObject(T obj);

    void updateObject(int id, T object);

    Optional<T> getObject(int id);

    void deleteObject(int id);

}
