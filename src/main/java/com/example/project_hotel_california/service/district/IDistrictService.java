package com.example.project_hotel_california.service.district;

import com.example.project_hotel_california.model.District;
import com.example.project_hotel_california.model.Province;
import com.example.project_hotel_california.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDistrictService extends IGeneralService<District> {
    List<District> getListDistrictByProvince(Province province);
    List<District> getListDistrictByProvinceId(Long id);
}
