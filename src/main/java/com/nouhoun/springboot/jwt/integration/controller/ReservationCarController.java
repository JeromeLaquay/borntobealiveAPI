package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.ReservationCar;
import com.nouhoun.springboot.jwt.integration.service.ReservationCarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/springjwt")
public class ReservationCarController {

    public ReservationCarController(ReservationCarService reservationCarService) {
        this.reservationCarService = reservationCarService;
    }

    private ReservationCarService reservationCarService;


    @RequestMapping(method = RequestMethod.POST, value="cars/reservations", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<ReservationCar> create(@RequestBody ReservationCar res) {
        try{
            ReservationCar res2 = reservationCarService.createOrUpdate(res);
            return new ResponseEntity<>(res2, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/cars/reservations")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<ReservationCar> get() { return reservationCarService.getAll(); }

    @DeleteMapping("/cars/reservations/{id}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public void delete(@PathVariable Integer id) {
        Optional<ReservationCar> resCar = reservationCarService.findById(id);
        reservationCarService.delete(resCar.get());
    }

    @RequestMapping(method = RequestMethod.GET, value="/cars/{id}/reservations")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<ReservationCar> findByCar(@PathVariable(value="id") Integer idCar) {
        return reservationCarService.findByCar(idCar);
    }

    @RequestMapping(method = RequestMethod.GET, value="/users/{id}/cars/reservations")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<ReservationCar> findByUser(@PathVariable(value="id") Integer idUser) {
        return reservationCarService.findByUser(idUser);
    }
}
