package com.example.project_hotel_california.service.house;

import com.example.project_hotel_california.dto.HouseDTO;
import com.example.project_hotel_california.model.*;
import com.example.project_hotel_california.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HouseService implements IHouseService<House>{

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private HouseStatusRepository houseStatusRepository;

    @Autowired
    private HouseTypeRepository houseTypeRepository;

    @Autowired
    private PhotoRepository photoRepository;

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
        House newHouse =  houseRepository.saveAndFlush(house);
        if(!Objects.isNull(house.getPhoto())) {
            photoRepository.saveAll(house.getPhoto().stream().map(photo -> new Photo(photo, newHouse.getId())).collect(Collectors.toList()));
        }
        return newHouse;
    }

    @Override
    public void remove(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public List<House> findHouseByCondition(HouseDTO houseDTO) {
        return houseRepository.findHouseByCondition(houseDTO);
    }

    public List<HouseType> findAllHouseType() {
        return houseTypeRepository.findAll();
    }

    public List<HouseStatus> findAllHouseStatus() {
        return houseStatusRepository.findAll();
    }

    public List<Village> findAllVillage() {
        return villageRepository.findAll();
    }

    public List<Photo> findAllPhoto() {
        return photoRepository.findAll();
    }
}
