package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.Station;
import com.nouhoun.springboot.jwt.integration.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StationController {

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    private StationService stationService;


    @RequestMapping(method = RequestMethod.POST, value="/stations", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<Station> create(@RequestBody Station station) {
        try{
            Station station2 = stationService.createOrUpdate(station);
            return new ResponseEntity<>(station2, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/stations")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<Station> get() { return stationService.getAll(); }

    @RequestMapping(method = RequestMethod.GET, value="/stations/free")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<Station> findFreeStations() { return stationService.findFreeStations(); }
}
