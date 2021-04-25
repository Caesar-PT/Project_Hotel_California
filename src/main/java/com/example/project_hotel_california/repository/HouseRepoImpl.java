package com.example.project_hotel_california.repository;

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
    public List<House> findHouseByCondition() {
        return null;
    }
}
