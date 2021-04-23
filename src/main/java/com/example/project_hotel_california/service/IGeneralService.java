package com.example.project_hotel_california.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();

    E add(E e);

    boolean remove(E e);

    E update(E e);

    E findById(Long id);
}
