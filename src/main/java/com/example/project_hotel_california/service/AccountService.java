package com.example.project_hotel_california.service;

import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.repository.AccountRepository;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public AppUser save(AppUser appUser) {
        return accountRepository.save(appUser);
    }

}
