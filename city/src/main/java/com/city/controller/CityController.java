package com.city.controller;

import com.city.exception.AlreadyExistException;
import com.city.exception.NotFoundException;
import com.city.model.City;
import com.city.model.District;
import com.city.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public City createCity(@RequestBody City city) throws AlreadyExistException {

        if(cityService.findCityByCityName(city.getCityName()).isPresent()){
            throw new AlreadyExistException("City already exist.");
        }

        if(!city.getDistricts().isEmpty()) {
            for (District district : city.getDistricts()) {
                district.setCity(city);
            }
        }
        return cityService.createCity(city);
    }

    @GetMapping("/{id}")
    public Optional<City> findCityById(@PathVariable Long id) throws NotFoundException {
        if(cityService.findCityById(id).isPresent()){
            return cityService.findCityById(id);
        }
        else throw new NotFoundException("City not found.");
    }

    @GetMapping("/{cityName}")
    public Optional<City> findCityByName(@PathVariable String cityName) throws NotFoundException {
        if(cityService.findCityByCityName(cityName).isPresent()){
            return cityService.findCityByCityName(cityName);
        }
        else throw new NotFoundException("City not found.");
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable Long id) throws NotFoundException {
        if(cityService.findCityById(id).isPresent()){
            cityService.deleteCityById(id);
            System.out.println("City deleted successfully:");
        } else throw new NotFoundException("City not found.");
    }

    @GetMapping("/sort-name")
    public List<City> sortCitiesAlphabetically(){
        List<City> cities = cityService.findAllCities();

        return cities.stream().sorted(Comparator.comparing(City::getCityName)).toList();
    }

    @GetMapping("/sort-plaka")
    public List<City> sortCitiesByPlakaCode(){
        List<City> cities = cityService.findAllCities();

        return cities.stream().sorted(Comparator.comparing(City::getPlakaCode)).toList();
    }
}
