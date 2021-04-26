package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.House;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HouseRepository extends JpaRepository<House, Long>, HouseRepo {
}
