package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate,Long> {
    @Query(value = "select * from rate where house_id = ?", nativeQuery = true)
    List<Rate> findAllByHouseId(Long id);
}
