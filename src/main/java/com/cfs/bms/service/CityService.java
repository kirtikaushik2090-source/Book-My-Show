package com.cfs.bms.service;

import com.cfs.bms.entity.City;
import com.cfs.bms.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    public City addCity(City city){
        return cityRepository.save(city);
    }
    public List<City>getAllCities(){
        return cityRepository.findAll();
    }
    public City getCityById(Long id){
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("city not found with id:"+id));
    }
}
