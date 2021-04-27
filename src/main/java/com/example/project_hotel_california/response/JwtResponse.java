package com.example.project_hotel_california.response;


import com.example.project_hotel_california.model.AppUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {

    //private Long id;
    private String token;
    private String type = "Bearer";
    private AppUser user;
   // private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, AppUser user) {
        this.token = accessToken;
        this.user = user;
       // this.username = username;
        //this.roles = roles;
    }
    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}