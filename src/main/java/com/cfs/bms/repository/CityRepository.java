package com.cfs.bms.repository;

import com.cfs.bms.entity.City;
import com.cfs.bms.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {



}
