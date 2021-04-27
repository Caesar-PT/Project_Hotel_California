package com.example.project_hotel_california.dto;

public class HouseDTO {
    private Long id;
    private String name;
    private String bedRoom;
    private String bathRoom;
    private String description;
    private String priceByDay;
    private String houseType;
    private String houseStatus;
    private String village;
    private String appUser;
    private String photoList;
    private String avatar;

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

    public String getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(String bedRoom) {
        this.bedRoom = bedRoom;
    }

    public String getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(String bathRoom) {
        this.bathRoom = bathRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceByDay() {
        return priceByDay;
    }

    public void setPriceByDay(String priceByDay) {
        this.priceByDay = priceByDay;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public String getPhotoList() {
        return photoList;
    }

    public void setPhotoList(String photoList) {
        this.photoList = photoList;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
