package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.dto.HouseDTO;
import com.example.project_hotel_california.model.*;
import com.example.project_hotel_california.service.house.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
@CrossOrigin("*")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping("")
    public ResponseEntity<List<House>> showAll() {
        List<House> houseList = houseService.findAll();
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    @GetMapping(value = "/view/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<House> view(@PathVariable Long id) {
        House house = houseService.findById(id);
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<House> create(@RequestBody House house) {
        houseService.save(house);
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<House> edit(@PathVariable Long id, @RequestBody House house) {
        house.setId(id);
        houseService.save(house);
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<House> delete(@PathVariable Long id) {
        houseService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/houseType")
    public ResponseEntity<List<HouseType>> showAllHouseType() {
        List<HouseType> houseTypeList = houseService.findAllHouseType();
        return new ResponseEntity<>(houseTypeList, HttpStatus.OK);
    }


    @GetMapping("/houseStatus")
    public ResponseEntity<List<HouseStatus>> showAllHouseStatus() {
        List<HouseStatus> houseStatus = houseService.findAllHouseStatus();
        return new ResponseEntity<>(houseStatus, HttpStatus.OK);
    }


    @GetMapping("/village")
    public ResponseEntity<List<Village>> showAllVillage() {
        List<Village> village = houseService.findAllVillage();
        return new ResponseEntity<>(village, HttpStatus.OK);
    }


    @GetMapping("/photo")
    public ResponseEntity<List<Photo>> showAllPhoto() {
        List<Photo> photo = houseService.findAllPhoto();
        return new ResponseEntity<>(photo, HttpStatus.OK);
    }

    @PostMapping("/show")
    public ResponseEntity<List<House>> search(@RequestBody HouseDTO houseDTO) {
        List<House> listHouse = houseService.findHouseByCondition(houseDTO);
        return new ResponseEntity<>(listHouse, HttpStatus.OK);
    }
}
