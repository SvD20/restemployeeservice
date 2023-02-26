package com.svyatdanilov.rest_employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

    List<T> findAll ();
    Optional<T> findById(int id);
    <S extends T> S save(S entity);
    void deleteById(int id);

}
