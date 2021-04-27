package com.example.project_hotel_california.model;

import javax.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String src;

    @Column(name = "house_id")
    private Long houseId;

    public Photo() {
    }

    public Photo(Long id, String src) {
        this.id = id;
        this.src = src;
    }

    public Photo(String src, Long houseId) {
        this.src = src;
        this.houseId = houseId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
