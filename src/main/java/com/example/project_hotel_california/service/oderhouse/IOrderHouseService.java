package com.example.project_hotel_california.service.oderhouse;

import com.example.project_hotel_california.model.OrderHouse;
import com.example.project_hotel_california.service.IGeneralService;

import java.util.Date;
import java.util.List;

public interface IOrderHouseService extends IGeneralService<OrderHouse> {
    List<OrderHouse> getAllByHouseId(Long id);
    List<OrderHouse> getAllByRenterId(Long id);
}
