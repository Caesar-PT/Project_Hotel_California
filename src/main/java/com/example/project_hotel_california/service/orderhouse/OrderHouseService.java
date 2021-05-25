package com.example.project_hotel_california.service.orderhouse;

import com.example.project_hotel_california.model.OrderHouse;
import com.example.project_hotel_california.repository.OrderHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderHouseService implements IOrderHouseService{
    @Autowired
    private OrderHouseRepository orderHouseRepository;

    @Override
    public List<OrderHouse> findAll() {
        return orderHouseRepository.findAll();
    }

    @Override
    public OrderHouse findById(Long id) {
        return orderHouseRepository.findById(id).get();
    }

    @Override
    public OrderHouse save(OrderHouse orderHouse) {
        return orderHouseRepository.save(orderHouse);
    }

    @Override
    public List<OrderHouse> getAllByHouseId(Long id) {
        return orderHouseRepository.getAllByHouseId(id);
    }

    @Override
    public void remove(Long id) {
        orderHouseRepository.deleteById(id);
    }

    @Override
    public List<OrderHouse> getAllByRenterId(Long id) {
        return orderHouseRepository.getAllByRenterId(id);
    }
}
