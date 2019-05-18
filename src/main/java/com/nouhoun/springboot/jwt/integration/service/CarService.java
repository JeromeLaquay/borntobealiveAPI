package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.Car;
import com.nouhoun.springboot.jwt.integration.domain.Station;
import com.nouhoun.springboot.jwt.integration.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarService {

    public CarService(CarRepository carRepository,
                      ReservationStationService resStationService,
                      ReservationCarService resCarService) {
        this.carRepository = carRepository;
        this.resCarService = resCarService;
        this.resStationService = resStationService;
    }

    private ReservationCarService resCarService;
    private ReservationStationService resStationService;

    private CarRepository carRepository;

    public Car createOrUpdate(Car car) {
        return carRepository.saveAndFlush(car);
    }

    public void delete(Car car){ carRepository.delete(car);}

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public List<Car> findByUser(Integer idUser){return carRepository.findByUser(idUser);}

    public List<Car> findWithoutUser(){return carRepository.findWithoutUser();}

    public Car findByImmatriculation(String immatriculation){ return carRepository.findbyImmatriculation(immatriculation);}

    public List<Car> getAllCarsFreeWithinPeriod(Date date_start, Date date_end){
        List<Car> carsFree = new ArrayList<>();
        List<Car> cars = carRepository.findAll();
        for(Car car : cars){
            if(!resStationService.existingReservationWithinPeriodForCar(car.getId(),date_start,date_end) && !resCarService.existingReservationWithinPeriod(car.getId(),date_start,date_end)){
                carsFree.add(car);
            }
        }
        return carsFree;
    }

}
