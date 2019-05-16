package com.nouhoun.springboot.jwt.integration.service;


import com.nouhoun.springboot.jwt.integration.domain.ReservationCar;
import com.nouhoun.springboot.jwt.integration.domain.ReservationStation;
import com.nouhoun.springboot.jwt.integration.repository.ReservationStationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationStationService {

    public ReservationStationService(ReservationStationRepository reservationStationRepository) {
        this.reservationStationRepository = reservationStationRepository;
    }

    private ReservationStationRepository reservationStationRepository;

    public ReservationStation createOrUpdate(ReservationStation res) {
        return reservationStationRepository.saveAndFlush(res);
    }

    public void delete(ReservationStation res){ reservationStationRepository.delete(res);}

    public List<ReservationStation> getAll() {
        return reservationStationRepository.findAll();
    }

    public Optional<ReservationStation> findById(Integer id) {
        return reservationStationRepository.findById(id);
    }

    public List<ReservationStation> findByStation(Integer idStation) {
        return reservationStationRepository.findByStation(idStation);
    }

    public List<ReservationStation> findByUser(Integer idUser) {
        return reservationStationRepository.findByUser(idUser);
    }

    public boolean existingReservationWithinPeriodForStation(Integer idStation, Date dateStart, Date dateEnd){
        return reservationStationRepository.findWithinPeriodForStation(idStation,dateStart,dateEnd).isEmpty() ? false : true;
    }

    public boolean existingReservationWithinPeriodForCar(Integer idCar, Date dateStart, Date dateEnd){
        return reservationStationRepository.findWithinPeriodForCar(idCar,dateStart,dateEnd).isEmpty() ? false : true;
    }
}
