package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getAllByStatus(Boolean status);
}
