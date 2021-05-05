package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.model.District;
import com.example.project_hotel_california.model.Province;
import com.example.project_hotel_california.model.Village;
import com.example.project_hotel_california.service.district.IDistrictService;
import com.example.project_hotel_california.service.province.IProvinceService;
import com.example.project_hotel_california.service.village.IVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private IVillageService villageService;

    @GetMapping("/province")
    public ResponseEntity<List<Province>> getAllProvince(){
        return new ResponseEntity<>(provinceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/district/{id}")
    public ResponseEntity<List<District>> getAllDistrictByProvinceId(@PathVariable Long id){
        return new ResponseEntity<>(districtService.getListDistrictByProvinceId(id), HttpStatus.OK);
    }

    @GetMapping("/village/{id}")
    public ResponseEntity<List<Village>> getALlVillageByDistrictId(@PathVariable Long id){
        return new ResponseEntity<>(villageService.getListVillageByDistrictId(id), HttpStatus.OK);
    }
}
