package com.example.project_hotel_california.service.house;

import com.example.project_hotel_california.dto.HouseDTO;
import com.example.project_hotel_california.model.*;
import com.example.project_hotel_california.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService implements IHouseService<House>{

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public House findById(Long id) {
        return houseRepository.findById(id).get();
    }

    @Override
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    public void remove(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public List<House> findHouseByCondition(HouseDTO houseDTO) {
        return houseRepository.findHouseByCondition(houseDTO);
    }

    public List<House> getAllHouseByAppUser(AppUser appUser){
        return houseRepository.getAllByAppUser(appUser);
    }
}
