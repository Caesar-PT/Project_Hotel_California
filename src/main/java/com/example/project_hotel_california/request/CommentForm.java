package com.example.project_hotel_california.request;


public class CommentForm {
    private Long id;

    private Long houseId;

    private String comment;

    public CommentForm(Long id,  Long houseId, String comment) {
        this.id = id;
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

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }
}
