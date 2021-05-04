package com.example.project_hotel_california.service.village;

import com.example.project_hotel_california.model.District;
import com.example.project_hotel_california.model.Village;
import com.example.project_hotel_california.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVillageService extends IGeneralService<Village> {
    List<Village> getListVillageByDistrict(District district);
    List<Village> getListVillageByDistrictId(Long id);
}
