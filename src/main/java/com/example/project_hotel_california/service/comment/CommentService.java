package com.example.project_hotel_california.service.comment;

import com.example.project_hotel_california.model.Comment;
import com.example.project_hotel_california.repository.CommentRepository;
import com.example.project_hotel_california.request.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllByHouseId(Long id) {
        return (List<Comment>) commentRepository.findAllByHouseId(id);
    }


}
