package com.example.project_hotel_california.service.rate;

import com.example.project_hotel_california.model.Comment;
import com.example.project_hotel_california.model.Rate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IRateService {
    Rate findById(Long id);

    Rate create(Rate rate);

    List<Rate> getAllByHouseId (Long id);
}
