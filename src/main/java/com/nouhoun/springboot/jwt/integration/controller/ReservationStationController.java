package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.ReservationStation;
import com.nouhoun.springboot.jwt.integration.service.ReservationStationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/springjwt")
public class ReservationStationController {

    public ReservationStationController(ReservationStationService reservationStationService) {
        this.reservationStationService = reservationStationService;
    }

    private ReservationStationService reservationStationService;


    @RequestMapping(method = RequestMethod.POST, value="/reservations_station", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<ReservationStation> create(@RequestBody ReservationStation res) {
        try{
            ReservationStation res2 = reservationStationService.createOrUpdate(res);
            return new ResponseEntity<>(res2, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/reservations_station")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<ReservationStation> get() { return reservationStationService.getAll(); }

    @DeleteMapping("/reservations_station/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public void deleteStudent(@PathVariable Integer id) {
        Optional<ReservationStation> resStation = reservationStationService.findById(id);
        reservationStationService.delete(resStation.get());
    }
}
