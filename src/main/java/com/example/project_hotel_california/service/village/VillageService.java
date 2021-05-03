package com.example.project_hotel_california.service.village;

import com.example.project_hotel_california.model.District;
import com.example.project_hotel_california.model.Village;
import com.example.project_hotel_california.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageService implements IVillageService {
    @Autowired
    private VillageRepository villageRepository;

    @Override
    public List<Village> findAll() {
        return villageRepository.findAll();
    }

    @Override
    public Village findById(Long id) {
        return null;
    }

    @Override
    public Village save(Village village) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Village> getListVillageByDistrict(District district) {
        return villageRepository.getAllByDistrict(district);
    }

    @Override
    public List<Village> getListVillageByDistrictId(Long id) {
        return villageRepository.getAllByDistrictId(id);
    }
}
