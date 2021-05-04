package com.example.project_hotel_california.service.rate;

import com.example.project_hotel_california.model.Comment;
import com.example.project_hotel_california.model.Rate;
import com.example.project_hotel_california.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RateService implements IRateService{
    @Autowired
    private RateRepository rateRepository;
    @Override
    public Rate findById(Long id) {
        return rateRepository.findById(id).get();
    }

    @Override
    public Rate create(Rate rate) {
        return rateRepository.save(rate);
    }

    @Override
    public List<Rate> getAllByHouseId(Long id) {
        return rateRepository.findAllByHouseId(id);
    }
}
