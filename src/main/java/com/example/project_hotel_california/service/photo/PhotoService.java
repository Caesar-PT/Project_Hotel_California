package com.example.project_hotel_california.service.photo;

import com.example.project_hotel_california.model.Photo;
import com.example.project_hotel_california.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoService implements IPhotoService{
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<Photo> findAll() {
        return null;
    }

    @Override
    public Photo findById(Long id) {
        return photoRepository.findById(id).get();
    }

    @Override
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public void remove(Long id) {
        photoRepository.deleteById(id);
    }

    @Override
    public List<Photo> getAllByHouseId(Long id) {
        return photoRepository.getAllByHouseId(id);
    }
}
