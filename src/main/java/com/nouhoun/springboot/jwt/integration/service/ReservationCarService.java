package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.ReservationCar;
import com.nouhoun.springboot.jwt.integration.repository.ReservationCarRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationCarService {

    public ReservationCarService(ReservationCarRepository reservationCarRepository) {
        this.reservationCarRepository = reservationCarRepository;
    }

    private ReservationCarRepository reservationCarRepository;

    public ReservationCar createOrUpdate(ReservationCar res) {
        return reservationCarRepository.saveAndFlush(res);
    }

    public void delete(ReservationCar res){ reservationCarRepository.delete(res);}

    public List<ReservationCar> getAll() {
        return reservationCarRepository.findAll();
    }

    public Optional<ReservationCar> findById(Integer id) {
        return reservationCarRepository.findById(id);
    }

    public List<ReservationCar> findByCar(Integer idCar) {
        return reservationCarRepository.findByCar(idCar);
    }

    public List<ReservationCar> findByUser(Integer idUser) {
        return reservationCarRepository.findByUser(idUser);
    }

    public boolean existingReservationWithinPeriod(Integer idCar, Date dateStart, Date dateEnd){
        return reservationCarRepository.findWithinPeriod(idCar,dateStart,dateEnd).isEmpty() ? false : true;
    }


}
