package com.example.project_hotel_california.service.district;

import com.example.project_hotel_california.model.District;
import com.example.project_hotel_california.model.Province;
import com.example.project_hotel_california.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictService implements IDistrictService{
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public District findById(Long id) {
        return null;
    }

    @Override
    public District save(District district) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<District> getListDistrictByProvince(Province province) {
        return districtRepository.getAllByProvince(province);
    }

    @Override
    public List<District> getListDistrictByProvinceId(Long id) {
        return districtRepository.getAllByProvinceId(id);
    }
}
