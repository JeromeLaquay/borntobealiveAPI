package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value="SELECT c FROM Car c, User a where c.user.id = a.id and a.id= :id")
    List<Car> findByUser(@Param("id")Integer idUser);

    @Query(value="SELECT c FROM Car c, User a where c.user.id is null")
    List<Car> findWithoutUser();

    @Query(value="SELECT c FROM Car c where c.immatriculation= :immatriculation")
    Car findbyImmatriculation(@Param("immatriculation")String immatriculation);

}
