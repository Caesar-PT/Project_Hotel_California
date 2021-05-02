package com.example.project_hotel_california.controller;

import com.example.project_hotel_california.model.AppUser;
import com.example.project_hotel_california.model.Comment;
import com.example.project_hotel_california.model.House;
import com.example.project_hotel_california.request.CommentForm;
import com.example.project_hotel_california.request.UserPrinciple;
import com.example.project_hotel_california.response.ResponseMessage;
import com.example.project_hotel_california.service.AccountService;
import com.example.project_hotel_california.service.comment.ICommentService;
import com.example.project_hotel_california.service.house.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    private UserPrinciple getCurrentUser() {
        return (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Comment>> showAllComment(@PathVariable Long id) {
        List<Comment> houseList = commentService.getAllByHouseId(id);
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody CommentForm commentForm) {
        UserPrinciple currentUser = (UserPrinciple)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = accountService.findByUsername(currentUser.getUsername());
        House house = houseService.findById(commentForm.getHouseId());
        Comment comment = new Comment(commentForm.getId(), appUser, house, commentForm.getComment());
        commentService.create(comment);
        return new ResponseEntity(comment, HttpStatus.CREATED);
    }

    @PostMapping("/create1")
    public ResponseEntity<ResponseMessage> createComment(@RequestBody Comment comment, @PathVariable Long houseId) {
        comment.setAppUser(this.accountService.findById(getCurrentUser().getId()));
        House house = houseService.findById(houseId);
        comment.setHouse(house);
        this.commentService.create(comment);
        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage(true, "COMMENT_SUCCESSFUL", null),
                HttpStatus.CREATED);
    }
}
