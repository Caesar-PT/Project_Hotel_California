package com.example.project_hotel_california.service.oderpost;

import com.example.project_hotel_california.model.OderPost;
import com.example.project_hotel_california.repository.OderPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderPostService implements IOderPost<OderPost>{
    @Autowired
    private OderPostRepository oderPostRepository;

    @Override
    public List<OderPost> findAll() {
        return oderPostRepository.findAll();
    }

    @Override
    public OderPost findById(Long id) {
        return oderPostRepository.findById(id).get();
    }

    @Override
    public OderPost save(OderPost oderPost) {
        return oderPostRepository.save(oderPost);
    }

    @Override
    public void remove(Long id) {

    }
}
