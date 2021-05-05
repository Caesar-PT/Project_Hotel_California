package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.dto.HouseDTO;
import com.example.project_hotel_california.model.House;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HouseRepoImpl implements HouseRepo{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<House> findHouseByCondition(HouseDTO houseDTO) {
        StringBuilder sql =new StringBuilder();
        sql.append("from House h where 1=1");
        if(houseDTO.getHouseType() != null && !"".equals(houseDTO.getHouseType().trim())){
            sql.append(" and house_type_id like '%").append(houseDTO.getHouseType()).append("%'");
        }
        if(houseDTO.getHouseStatus() != null && !"".equals(houseDTO.getHouseStatus().trim())){
            sql.append(" and house_status_id = " + houseDTO.getHouseStatus());
        }
        if(houseDTO.getProvince() != null && !"".equals(houseDTO.getProvince().trim())){
            sql.append(" and h.village.district.province.id = " + houseDTO.getProvince());
        }
        if(houseDTO.getDistrict() != null && !"".equals(houseDTO.getDistrict().trim())){
            sql.append(" and h.village.district.id = " + houseDTO.getDistrict());
        }
        if(houseDTO.getVillage() != null && !"".equals(houseDTO.getVillage().trim())){
            sql.append(" and village_id = " + houseDTO.getVillage());
        }
        if(houseDTO.getBedRoom() != null && !"".equals(houseDTO.getBedRoom().trim())){
            sql.append(" and bed_room = " + houseDTO.getBedRoom());
        }
        if(houseDTO.getBathRoom() != null && !"".equals(houseDTO.getBathRoom().trim())){
            sql.append(" and bath_room = " + houseDTO.getBathRoom());
        }
        if(houseDTO.getPriceMinDay() != null && !"".equals(houseDTO.getPriceMinDay().trim())){
            sql.append(" and price_by_day > " + houseDTO.getPriceMinDay());
        }
        if(houseDTO.getPriceMaxDay() != null && !"".equals(houseDTO.getPriceMaxDay().trim())){
            sql.append(" and price_by_day < " + houseDTO.getPriceMaxDay());
        }
        return entityManager.createQuery(sql.toString()).getResultList();
    }
}
