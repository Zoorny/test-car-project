package com.tecom.database.repository;

import com.tecom.database.model.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAll(Sort sort);
}
