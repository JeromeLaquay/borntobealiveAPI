package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.ReservationCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationCarRepository extends JpaRepository<ReservationCar, Integer> {

    @Query(value="SELECT r FROM ReservationCar r where r.car.id = :id")
    List<ReservationCar> findByCar(@Param("id")Integer idCar);

    @Query(value="SELECT r FROM ReservationCar r where r.user.id = :id")
    List<ReservationCar> findByUser(@Param("id")Integer idUser);

    @Query(value="SELECT t.id, t.date_start, t.date_end FROM ReservationCar AS t WHERE  t.car.id = :id AND t.date_start < :date_end AND t.date_end > :date_start GROUP BY t.id, t.date_start, t.date_end")
    List<ReservationCar> findWithinPeriod(@Param("id") Integer idCar, @Param("date_start") Date dateStart, @Param("date_end") Date dateEnd);
}