package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.model.Post;
import com.example.project_hotel_california.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPost(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Post> view(@PathVariable Long id){
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Post> editPost(@PathVariable Long id, @RequestBody Post post){
        post.setId(id);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> delPost(@PathVariable Long id){
        postService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
