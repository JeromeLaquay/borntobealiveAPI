package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.ReservationCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationCarRepository extends JpaRepository<ReservationCar, Integer> {

    @Query(value="SELECT r FROM ReservationCar r where r.car.id = :id")
    List<ReservationCar> findByCar(@Param("id")Integer idCar);

    @Query(value="SELECT r FROM ReservationCar r where r.user.id = :id")
    List<ReservationCar> findByUser(@Param("id")Integer idUser);
}