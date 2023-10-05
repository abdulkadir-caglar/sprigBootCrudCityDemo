package com.city.controller;

import com.city.model.District;
import com.city.service.DistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/district")
@RestController
public class DistrictController {
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping
    public District createDistrict(@RequestBody District district){
        return districtService.createDistrict(district);
    }

    @GetMapping("/{id}")
    public Optional<District> findDistrictById(@PathVariable Long id){
        return districtService.findDistrictById(id);
    }
}
