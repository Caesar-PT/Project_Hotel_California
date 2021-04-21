package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.config.JwtTokenUtil;
import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.repository.AccountRepository;
import com.example.project_hotel_california.request.Login;
import com.example.project_hotel_california.request.SignUp;
import com.example.project_hotel_california.response.ResponseMessage;
import com.example.project_hotel_california.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController<IAuthenticationManager> {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private AccountRepository accountRepository;






    @PostMapping("/signup")
    public ResponseEntity<ResponseMessage> registerUser(@Valid @RequestBody SignUp signUpRequest) throws Exception {

        if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<ResponseMessage>(
                    new ResponseMessage(false, "USERNAME", null),
                    HttpStatus.BAD_REQUEST);
        }

        if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<ResponseMessage>(
                    new ResponseMessage(false, " Nhập sai dạng email (abc@gmail.com) !", null),
                    HttpStatus.BAD_REQUEST);
        }

        AppUser user = new AppUser(signUpRequest.getFullName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                signUpRequest.getPassword(), signUpRequest.getPhoneNumber(), signUpRequest.getAddress());

        accountService.save(user);

        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage(true, "DANG KI THANH CONG!", null),
                HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login login) throws Exception {
        Long userId = 6l;
        String token = new JwtTokenUtil().createToken(userId);
        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage(true, "DANG KI THANH CONG!", null),
                HttpStatus.OK);
    }
}
