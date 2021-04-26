package com.example.project_hotel_california.service.post;

import com.example.project_hotel_california.dto.HouseDTO;

import java.util.List;

public interface IPostService<E> {
    List<E> findAll();

    E findById(Long id);

    E save(E e);

    void remove(Long id);

    List<E> getAllPostByStatus(boolean status);
}
