package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nydiarra on 10/05/17.
 */
@Repository
public interface RandomCityRepository extends JpaRepository<RandomCity, Long> {
}
