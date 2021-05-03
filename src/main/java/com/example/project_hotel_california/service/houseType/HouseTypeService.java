package com.example.project_hotel_california.service.houseType;

import com.example.project_hotel_california.model.HouseType;
import com.example.project_hotel_california.repository.HouseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseTypeService implements IHouseTypeService{
    @Autowired
    private HouseTypeRepository houseTypeRepository;

    @Override
    public List<HouseType> findAll() {
        return houseTypeRepository.findAll();
    }

    @Override
    public HouseType findById(Long id) {
        return houseTypeRepository.findById(id).get();
    }

    @Override
    public HouseType save(HouseType houseType) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
