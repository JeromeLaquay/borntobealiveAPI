package com.nouhoun.springboot.jwt.integration.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modele; // Zoe, Model S,
    private String marque; // Renault, Tesla, BMW
    private String immatriculation;
    private Integer power_max; // en KW/h
    private Integer km_max;
    private String organisation; // La catho, Yncrea ...

    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy="car")
    private List<ReservationCar> reservationCarList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getPower_max() {
        return power_max;
    }

    public void setPower_max(Integer power_max) {
        this.power_max = power_max;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ReservationCar> getReservationCarList() {
        return reservationCarList;
    }

    public void setReservationCarList(List<ReservationCar> reservationCarList) {
        this.reservationCarList = reservationCarList;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Integer getKm_max() {
        return km_max;
    }

    public void setKm_max(Integer km_max) {
        this.km_max = km_max;
    }
}
