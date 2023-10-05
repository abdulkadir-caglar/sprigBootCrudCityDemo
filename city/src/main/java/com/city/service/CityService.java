package com.city.service;

import com.city.model.City;
import com.city.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public City createCity(City city){
        return cityRepository.save(city);
    }

    public Optional<City> findCityById(Long id){
        return cityRepository.findById(id);
    }

    public Optional<City> findCityByCityName(String cityName){
        return cityRepository.findCityByCityName(cityName);
    }

    public void deleteCityById(Long id){
        cityRepository.deleteById(id);
    }

    public List<City> findAllCities(){
        return cityRepository.findAll();
    }
}
