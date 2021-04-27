package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.config.JwtTokenUtil;
import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.repository.AccountRepository;
import com.example.project_hotel_california.request.Login;
import com.example.project_hotel_california.request.SignUp;
import com.example.project_hotel_california.response.JwtResponse;
import com.example.project_hotel_california.response.ResponseMessage;
import com.example.project_hotel_california.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @PostMapping("/signup")
    public ResponseEntity<ResponseMessage> registerUser( @RequestBody SignUp signUpRequest){
//
//        if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
//            return new ResponseEntity<ResponseMessage>(
//                    new ResponseMessage(false, "USERNAME", null),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity<ResponseMessage>(
//                    new ResponseMessage(false, " Nhập sai dạng email (abc@gmail.com) !", null),
//                    HttpStatus.BAD_REQUEST);
//        }

        AppUser user = new AppUser(signUpRequest.getUsername(), bcryptEncoder.encode(signUpRequest.getPassword()) ,
                signUpRequest.getFullName(), signUpRequest.getAddress(),
                signUpRequest.getPhoneNumber(), signUpRequest.getEmail(),signUpRequest.getAvatar()
        );

        accountService.save(user);

        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage(true, "DANG KI THANH CONG!", null),
                HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenUtil.generateAccessToken(login.getUsername());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = accountService.getCurrentUser();
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser));
       // return new ResponseEntity<>(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()), HttpStatus.OK);
        //return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("")
    public ResponseEntity<?> hello() {
        return new ResponseEntity<>(accountService.list(), HttpStatus.OK);
    }
}
