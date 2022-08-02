package com.example.project_hotel_california.service.oderhouse;

import com.example.project_hotel_california.model.OrderHouse;
import com.example.project_hotel_california.repository.OrderHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class OrderService implements IOrderHouseService {
    @Autowired
    private OrderHouseRepository orderHouseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderHouse> findAll() {
        return orderHouseRepository.findAll();
    }

    @Override
    public OrderHouse findById(Long id) {
        return orderHouseRepository.findById(id).get();
    }

    @Override
    public OrderHouse save(OrderHouse orderHouse) {
        return orderHouseRepository.save(orderHouse);
    }

    @Override
    public void remove(Long id) {
            orderHouseRepository.deleteById(id);
    }

    @Override
    public List<OrderHouse> getOrderHouse(Long id){
        String query = "from OrderHouse o where o.house.appUser.id = " + id;
        return entityManager.createQuery(query).getResultList();
    }

}
