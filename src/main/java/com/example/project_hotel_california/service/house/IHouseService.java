package com.example.project_hotel_california.service.house;

import com.example.project_hotel_california.dto.HouseDTO;
import com.example.project_hotel_california.model.House;

import java.util.List;

public interface IHouseService<E>{
    List<E> findAll();

    E findById(Long id);

    E save(E e);

    void remove(Long id);

    List<E> findHouseByCondition(HouseDTO houseDTO);
}
