package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.Station;
import com.nouhoun.springboot.jwt.integration.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    private StationRepository stationRepository;

    public Station createOrUpdate(Station station) {
        return stationRepository.saveAndFlush(station);
    }

    public void delete(Station station){ stationRepository.delete(station);}

    public List<Station> getAll() {
        return stationRepository.findAll();
    }

    public List<Station> findFreeStations(){
        return stationRepository.findFreeStations();
    }
}
