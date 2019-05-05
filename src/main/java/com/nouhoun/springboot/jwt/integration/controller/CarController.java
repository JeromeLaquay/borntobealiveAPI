package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.Car;
import com.nouhoun.springboot.jwt.integration.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springjwt")
public class CarController {

    public CarController(CarService carService) {
        this.carService = carService;
    }

    private CarService carService;


    @RequestMapping(method = RequestMethod.POST, value="/cars", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        try{
            Car car2 = carService.createOrUpdate(car);
            return new ResponseEntity<>(car2, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/cars")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<Car> get() {
        return carService.getAll();
    }
}
