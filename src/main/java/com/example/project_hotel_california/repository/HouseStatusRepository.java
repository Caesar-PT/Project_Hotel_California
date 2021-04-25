package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.HouseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseStatusRepository extends JpaRepository<HouseStatus, Long> {
}
