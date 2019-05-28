package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.Car;
import com.nouhoun.springboot.jwt.integration.domain.Station;
import com.nouhoun.springboot.jwt.integration.repository.ReservationStationRepository;
import com.nouhoun.springboot.jwt.integration.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StationService {

    public StationService(StationRepository stationRepository, ReservationStationService resStationService) {
        this.stationRepository = stationRepository;
        this.resStationService = resStationService;
    }

    private StationRepository stationRepository;
    private ReservationStationService resStationService;

    public Station createOrUpdate(Station station) {
        return stationRepository.saveAndFlush(station);
    }

    public void delete(Station station){ stationRepository.delete(station);}

    public List<Station> getAll() {
        return stationRepository.findAll();
    }

    public List<Station> getAllStationsFreeWithinPeriod(Date date_start, Date date_end){
        List<Station> stationsFree = new ArrayList<>();
        List<Station> stations = stationRepository.findAll();
        for(Station station : stations){
            if(!resStationService.existingReservationWithinPeriodForStation(station.getId(),date_start,date_end)){
                stationsFree.add(station);
            }
        }
        return stationsFree;
    }

    public Station findByName(String name){ return stationRepository.findbyName(name);}
}
