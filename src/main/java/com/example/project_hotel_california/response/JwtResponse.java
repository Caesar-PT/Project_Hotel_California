package com.example.project_hotel_california.response;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
   // private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        //this.roles = roles;
    }

}