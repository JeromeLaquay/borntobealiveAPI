package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.config.DateUtil;
import com.nouhoun.springboot.jwt.integration.domain.ReservationCar;
import com.nouhoun.springboot.jwt.integration.domain.ReservationStation;
import com.nouhoun.springboot.jwt.integration.service.ReservationStationService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationStationController {

    public ReservationStationController(ReservationStationService reservationStationService) {
        this.reservationStationService = reservationStationService;
    }

    private ReservationStationService reservationStationService;


    @RequestMapping(method = RequestMethod.POST, value="/stations/reservations", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ReservationStation create(@RequestBody ReservationStation res) {
        try{
            ReservationStation res2 = reservationStationService.createOrUpdate(res);
            return res2;
        }catch(Exception e){
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/stations/reservations")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<ReservationStation> get() { return reservationStationService.getAll(); }

    @DeleteMapping("stations/reservations/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public void deleteStudent(@PathVariable Integer id) {
        Optional<ReservationStation> resStation = reservationStationService.findById(id);
        reservationStationService.delete(resStation.get());
    }

    @RequestMapping(method = RequestMethod.GET, value="/stations/{id}/reservations")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<ReservationStation> findByStation(@PathVariable(value="id") Integer idStation) {
        return reservationStationService.findByStation(idStation);
    }

    @RequestMapping(method = RequestMethod.GET, value="/users/{id}/stations/reservations")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<ReservationStation> findByUser(@PathVariable(value="id") Integer idUser) {
        return reservationStationService.findByUser(idUser);
    }

    @RequestMapping(method = RequestMethod.GET, value="/stations/{id}/reservations/existing")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public boolean existingReservationWithinPeriod(@PathVariable(value="id") Integer idStation, @Param("date_start") String date_start , @Param("date_end") String date_end) throws ParseException {
        return reservationStationService.existingReservationWithinPeriodForStation(idStation, DateUtil.stringToDate(date_start),DateUtil.stringToDate(date_end));
    }


}
