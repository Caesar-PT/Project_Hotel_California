package com.example.project_hotel_california.service.photo;

import com.example.project_hotel_california.model.Photo;
import com.example.project_hotel_california.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPhotoService extends IGeneralService<Photo> {
    List<Photo> getAllByHouseId(Long id);
}
