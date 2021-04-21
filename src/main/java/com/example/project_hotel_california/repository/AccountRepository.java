package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.AppUser;
import org.springframework.data.repository.CrudRepository;



public interface AccountRepository extends CrudRepository<AppUser, Long> {
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
