package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.House;

import java.util.List;

public interface HouseRepo {
    List<House> findHouseByCondition();
}
