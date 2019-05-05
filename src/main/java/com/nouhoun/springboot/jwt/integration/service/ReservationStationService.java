package com.nouhoun.springboot.jwt.integration.service;


import com.nouhoun.springboot.jwt.integration.domain.ReservationStation;
import com.nouhoun.springboot.jwt.integration.repository.ReservationStationRepository;
import org.springframework.stereotype.Service;

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

}
