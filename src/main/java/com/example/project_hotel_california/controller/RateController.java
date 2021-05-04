package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.model.House;
import com.example.project_hotel_california.model.Rate;

import com.example.project_hotel_california.request.RateForm;
import com.example.project_hotel_california.request.UserPrinciple;
import com.example.project_hotel_california.service.AccountService;
import com.example.project_hotel_california.service.house.HouseService;
import com.example.project_hotel_california.service.rate.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rate")
public class RateController {
    @Autowired
    private IRateService rateService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private HouseService houseService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Rate>> showAllRate(@PathVariable Long id) {
            List<Rate> houseList = rateService.getAllByHouseId(id);
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Rate> createRate(@RequestBody RateForm rateForm) {
        UserPrinciple currentUser = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = accountService.findByUsername(currentUser.getUsername());
        House house = houseService.findById(rateForm.getHouseId());
        Rate rate = new Rate(rateForm.getId(), appUser, house, rateForm.getStar());
        rateService.create(rate);
        return new ResponseEntity(rate, HttpStatus.CREATED);
    }
}
