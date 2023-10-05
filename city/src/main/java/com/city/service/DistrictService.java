package com.city.service;

import com.city.model.District;
import com.city.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District createDistrict(District district){
        return districtRepository.save(district);
    }

    public Optional<District> findDistrictById(Long id){
        return districtRepository.findById(id);
    }
}
