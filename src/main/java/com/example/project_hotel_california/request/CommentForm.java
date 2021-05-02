package com.example.project_hotel_california.request;

import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.model.House;

import javax.persistence.ManyToOne;

public class CommentForm {
    private Long id;

    private Long userId;

    private Long houseId;

    private String comment;

    public CommentForm(Long id, Long userId, Long houseId, String comment) {
        this.id = id;
        this.userId = userId;
        this.houseId = houseId;
        this.comment = comment;
    }

    public CommentForm() {
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }
}
