package com.example.project_hotel_california.service.province;

import com.example.project_hotel_california.model.Province;
import com.example.project_hotel_california.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService{
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return null;
    }

    @Override
    public Province save(Province province) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
