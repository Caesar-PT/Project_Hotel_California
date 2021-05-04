package com.example.project_hotel_california.request;

public class RateForm {
    private Long id;

    private Long houseId;

    private Double star;

    public RateForm() {
    }

    public RateForm(Long id, Long houseId, Double rate) {
        this.id = id;
        this.houseId = houseId;
        this.star = star;
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

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }
}
