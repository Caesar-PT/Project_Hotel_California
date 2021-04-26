package com.example.project_hotel_california.service.oderpost;

import java.util.List;

public interface IOderPost<E> {
    List<E> findAll();

    E findById(Long id);

    E save(E e);

    void remove(Long id);
}
