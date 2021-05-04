package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.Comment;
import com.example.project_hotel_california.request.CommentForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = "select * from comment where house_id = ?", nativeQuery = true)
    List<Comment> findAllByHouseId(Long id);
}
