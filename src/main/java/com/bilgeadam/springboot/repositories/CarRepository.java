package com.bilgeadam.springboot.repositories;

import com.bilgeadam.springboot.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByYear(Integer year);

    Optional<Car> findByYearAndBrandAndModel(Integer year, String brand, String model);

    @Query(value = "SELECT MAX(c.id) FROM Car c")
    Integer getMaxId();
}
