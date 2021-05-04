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
        sql.append("from House h join h.village v where 1=1");
        if(houseDTO.getName() != null && !"".equals(houseDTO.getName().trim())){
            sql.append(" and h.name like '%").append(houseDTO.getName()).append("%'");
        }
        if(houseDTO.getHouseType() != null && !"".equals(houseDTO.getHouseType().trim())){
            sql.append(" and house_type_id like '%").append(houseDTO.getHouseType()).append("%'");
        }
        if(houseDTO.getHouseStatus() != null && !"".equals(houseDTO.getHouseStatus().trim())){
            sql.append(" and house_status_id like '%").append(houseDTO.getHouseStatus()).append("%'");
        }
        if(houseDTO.getVillage() != null && !"".equals(houseDTO.getVillage().trim())){
            sql.append(" and village_id like '%").append(houseDTO.getVillage()).append("%' and  village_id = v.id");
        }
        if(houseDTO.getPriceByDay() != null && !"".equals(houseDTO.getPriceByDay())){
            sql.append(" and price_by_day < " + houseDTO.getPriceByDay());
        }
        return entityManager.createQuery(sql.toString()).getResultList();
    }
}
