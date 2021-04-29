package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.OrderHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderPostRepository extends JpaRepository<OrderHouse, Long> {
}
