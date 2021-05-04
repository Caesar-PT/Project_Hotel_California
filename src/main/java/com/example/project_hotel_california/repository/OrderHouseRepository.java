package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.OrderHouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderHouseRepository extends JpaRepository<OrderHouse, Long> {
}
