package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.ReservationCar;
import com.nouhoun.springboot.jwt.integration.domain.ReservationStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationStationRepository extends JpaRepository<ReservationStation, Integer> {

    @Query(value="SELECT r FROM ReservationStation r where r.station.id = :id")
    List<ReservationStation> findByStation(@Param("id")Integer idStation);

    @Query(value="SELECT r FROM ReservationStation r where r.user.id = :id")
    List<ReservationStation> findByUser(@Param("id")Integer idUser);
}
