package com.example.project_hotel_california.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StatusHouseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private House house;

    private Date startDate;
    private Date endDate;

    public StatusHouseTime(Long id, House house, Date startDate, Date endDate) {
        this.id = id;
        this.house = house;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public StatusHouseTime() {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
