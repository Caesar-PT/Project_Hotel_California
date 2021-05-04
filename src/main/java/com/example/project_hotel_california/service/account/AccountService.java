package com.example.project_hotel_california.service.account;

import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public AppUser save(AppUser appUser) {
        return accountRepository.save(appUser);
    }

    @Override
    public List<AppUser> list() {
        return (List<AppUser>) accountRepository.findAll();
    }

    @Override
    public AppUser getCurrentUser() {
        AppUser user;
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        user = this.accountRepository.findByUsername(userName);
        return user;
    }

    @Override
    public AppUser findById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public AppUser findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

}
