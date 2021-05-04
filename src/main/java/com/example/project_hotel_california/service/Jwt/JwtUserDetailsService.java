package com.example.project_hotel_california.service.Jwt;

import java.util.ArrayList;
import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.repository.AccountRepository;
import com.example.project_hotel_california.request.Login;
import com.example.project_hotel_california.request.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = accountRepository.findByUsername(username);

        return UserPrinciple.build(user);
    }

    public AppUser save(Login login) {
        AppUser newUser = new AppUser();
        newUser.setUsername(login.getUsername());
        newUser.setPassword(bcryptEncoder.encode(login.getPassword()));
        return accountRepository.save(newUser);
    }
}
