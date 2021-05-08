package com.example.project_hotel_california.service.account;

import com.example.project_hotel_california.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAccountService {

    AppUser save(AppUser appUser);

    List<AppUser> list();

    AppUser getCurrentUser();

    AppUser findById(Long id);

    AppUser findByUsername(String username);
}
