package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.District;
import com.example.project_hotel_california.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> getAllByProvince(Province province);
    List<District> getAllByProvinceId(Long id);
}
