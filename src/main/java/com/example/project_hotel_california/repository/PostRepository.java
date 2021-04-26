package com.example.project_hotel_california.repository;

import com.example.project_hotel_california.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
