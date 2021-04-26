package com.example.project_hotel_california.service.houseStatus;

import com.example.project_hotel_california.model.HouseStatus;
import com.example.project_hotel_california.repository.HouseStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseStatusService implements IHouseStatus<HouseStatus>{
    @Autowired
    private HouseStatusRepository houseStatusRepository;

    @Override
    public List<HouseStatus> findAll() {
        return houseStatusRepository.findAll();
    }

    @Override
    public HouseStatus findById(Long id) {
        return houseStatusRepository.findById(id).get();
    }

    @Override
    public HouseStatus save(HouseStatus houseStatus) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
