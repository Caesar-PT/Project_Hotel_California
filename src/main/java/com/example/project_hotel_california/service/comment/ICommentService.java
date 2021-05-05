package com.example.project_hotel_california.service.comment;

import com.example.project_hotel_california.model.Comment;
import com.example.project_hotel_california.request.CommentForm;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICommentService {
    List<Comment> findAll();

    Comment findById(Long id);

    Comment create(Comment comment);

    List<Comment> getAllByHouseId (Long id , int index);
}
