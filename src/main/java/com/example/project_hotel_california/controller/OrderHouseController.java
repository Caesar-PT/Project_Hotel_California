package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.model.OrderHouse;
import com.example.project_hotel_california.service.orderhouse.OrderHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderHouseController {
    @Autowired
    private OrderHouseService orderHouseService;

    @GetMapping("/listorder")
    public ResponseEntity<List<OrderHouse>> getAll(){
        return new ResponseEntity<>(orderHouseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderHouse> findById(@PathVariable Long id){
        return new ResponseEntity<>(orderHouseService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderHouse> del(@PathVariable Long id){
        orderHouseService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
