package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.model.Comment;
import com.example.project_hotel_california.model.House;
import com.example.project_hotel_california.request.CommentForm;
import com.example.project_hotel_california.service.AccountService;
import com.example.project_hotel_california.service.comment.ICommentService;
import com.example.project_hotel_california.service.house.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private HouseService houseService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Comment>> showAllComment(@PathVariable Long id) {
        List<Comment> houseList = commentService.getAllByHouseId(id);
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody CommentForm commentForm) {
        AppUser appUser = accountService.findById(commentForm.getUserId());
        House house = houseService.findById(commentForm.getHouseId());
        Comment comment = new Comment(commentForm.getId(), appUser, house, commentForm.getComment());
        commentService.create(comment);
        return new ResponseEntity(comment, HttpStatus.CREATED);
    }


}
