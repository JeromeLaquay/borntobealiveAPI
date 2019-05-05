package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {


}
