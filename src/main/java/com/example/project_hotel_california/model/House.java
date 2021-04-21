package com.example.project_hotel_california.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double bedRoom;
    private double bathRoom;
    private String description;
    private double priceByDay;

    @ManyToOne
    private HouseType houseType;

    @ManyToOne
    private HouseStatus houseStatus;

    @ManyToOne
    private Village village;

    @ManyToOne
    private AppUser appUser;

    @Transient
    private MultipartFile avatar;

    public House() {
    }

    public House(Long id, String name, double bedRoom, double bathRoom, String description, double priceByDay, HouseType houseType, HouseStatus houseStatus, Village village, AppUser appUser, MultipartFile avatar) {
        this.id = id;
        this.name = name;
        this.bedRoom = bedRoom;
        this.bathRoom = bathRoom;
        this.description = description;
        this.priceByDay = priceByDay;
        this.houseType = houseType;
        this.houseStatus = houseStatus;
        this.village = village;
        this.appUser = appUser;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(double bedRoom) {
        this.bedRoom = bedRoom;
    }

    public double getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(double bathRoom) {
        this.bathRoom = bathRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceByDay() {
        return priceByDay;
    }

    public void setPriceByDay(double priceByDay) {
        this.priceByDay = priceByDay;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public HouseStatus getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
