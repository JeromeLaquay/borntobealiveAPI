package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.Car;
import com.nouhoun.springboot.jwt.integration.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

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

}
