package com.example.project_hotel_california.service.orderhouse;

import com.example.project_hotel_california.model.OrderHouse;
import com.example.project_hotel_california.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderHouseService extends IGeneralService<OrderHouse> {
    List<OrderHouse> getAllByHouseId(Long id);
    List<OrderHouse> getAllByRenterId(Long id);
}
