package com.example.project_hotel_california.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private House house;

    private Date checkin;
    private Date checkout;

    @ManyToOne
    private AppUser appUser;

    public OrderHouse() {
    }

    public OrderHouse(Long id, House house, Date checkin, Date checkout, AppUser appUser) {
        this.id = id;
        this.house = house;
        this.checkin = checkin;
        this.checkout = checkout;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
