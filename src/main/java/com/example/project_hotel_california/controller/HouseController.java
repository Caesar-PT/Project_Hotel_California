package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.dto.HouseDTO;
import com.example.project_hotel_california.model.*;
import com.example.project_hotel_california.repository.PhotoRepository;
import com.example.project_hotel_california.service.account.IAccountService;
import com.example.project_hotel_california.service.district.DistrictService;
import com.example.project_hotel_california.service.house.HouseService;
import com.example.project_hotel_california.service.houseStatus.HouseStatusService;
import com.example.project_hotel_california.service.houseType.HouseTypeService;
import com.example.project_hotel_california.service.oderhouse.IOrderHouseService;
import com.example.project_hotel_california.service.province.ProvinceService;
import com.example.project_hotel_california.service.village.VillageService;
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

    @Autowired
    private HouseTypeService houseTypeService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IOrderHouseService orderHouseService;

    @Autowired
    private VillageService villageService;

    @Autowired
    private HouseStatusService houseStatusService;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public ResponseEntity<List<House>> showAll() {
        List<House> houseList = houseService.findAll();
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<House> getBook(@PathVariable("id") Long id) {
        House house = houseService.findById(id);
        return new ResponseEntity<>(house, HttpStatus.OK);
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
        List<HouseType> houseTypeList = houseTypeService.findAll();
        return new ResponseEntity<>(houseTypeList, HttpStatus.OK);
    }

    @GetMapping("/houseType/{id}")
    public ResponseEntity<HouseType> getHouseTypeById(@PathVariable Long id){
        HouseType houseType = houseTypeService.findById(id);
        return new ResponseEntity<>(houseType, HttpStatus.OK);
    }


    @GetMapping("/houseStatus")
    public ResponseEntity<List<HouseStatus>> showAllHouseStatus() {
        List<HouseStatus> houseStatus = houseStatusService.findAll();
        return new ResponseEntity<>(houseStatus, HttpStatus.OK);
    }

    @GetMapping("/village")
    public ResponseEntity<List<Village>> showAllVillage() {
        List<Village> village = villageService.findAll();
        return new ResponseEntity<>(village, HttpStatus.OK);
    }

    @GetMapping("/district")
    public ResponseEntity<List<District>> showAllDistrict() {
        List<District> district = districtService.findAll();
        return new ResponseEntity<>(district, HttpStatus.OK);
    }

    @GetMapping("/province")
    public ResponseEntity<List<Province>> showAllProvince() {
        List<Province> province = provinceService.findAll();
        return new ResponseEntity<>(province, HttpStatus.OK);
    }

    @GetMapping("/photo")
    public ResponseEntity<List<Photo>> showAllPhoto() {
        List<Photo> photo = photoRepository.findAll();
        return new ResponseEntity<>(photo, HttpStatus.OK);
    }

    @PostMapping("/show")
    public ResponseEntity<List<House>> search(@RequestBody HouseDTO houseDTO) {
        List<House> listHouse = houseService.findHouseByCondition(houseDTO);
        return new ResponseEntity<>(listHouse, HttpStatus.OK);
    }

    @PostMapping("/view/{id}/booking")
    public ResponseEntity<OrderHouse> bookingHouse(@PathVariable Long id, @RequestBody OrderHouse orderHouse){
        House house = houseService.findById(id);
        AppUser user = accountService.getCurrentUser();
        orderHouse.setHouse(house);
        orderHouse.setAppUser(user);
        orderHouseService.save(orderHouse);
        return new ResponseEntity<>(orderHouse, HttpStatus.OK);
    }


}
