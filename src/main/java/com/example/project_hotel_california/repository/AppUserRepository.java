package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.AppRole;
import com.example.project_hotel_california.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> getAppUserByUsername(String name);
}
