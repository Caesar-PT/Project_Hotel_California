package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.model.Photo;
import com.example.project_hotel_california.service.photo.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
@CrossOrigin("*")
public class PhotoController {
    @Autowired
    private IPhotoService photoService;

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable Long id){
        return new ResponseEntity<>(photoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Photo> createPhoto(@RequestBody Photo photo){
        return new ResponseEntity<>(photoService.save(photo), HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Photo>> getALlPhotoByIdHouse(@PathVariable Long id) {
        return new ResponseEntity<>(photoService.getAllByHouseId(id), HttpStatus.OK);
    }
}
