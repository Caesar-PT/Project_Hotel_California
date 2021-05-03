package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.District;
import com.example.project_hotel_california.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VillageRepository extends JpaRepository<Village,Long> {
    List<Village> getAllByDistrict(District district);
    List<Village> getAllByDistrictId(Long id);
}
