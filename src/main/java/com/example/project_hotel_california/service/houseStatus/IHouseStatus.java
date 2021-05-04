package com.example.project_hotel_california.service.houseStatus;

import java.util.List;

public interface IHouseStatus<E> {
    List<E> findAll();

    E findById(Long id);

    E save(E e);

    void remove(Long id);
}
