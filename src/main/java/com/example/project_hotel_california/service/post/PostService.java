package com.example.project_hotel_california.service.post;

import com.example.project_hotel_california.model.Post;
import com.example.project_hotel_california.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostService implements IPostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post add(Post post) {
        return postRepository.save(post);
    }

    @Override
    public boolean remove(Post post) {
        if (post == null) {
            return false;
        }else {
            postRepository.delete(post);
            return true;
        }
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.getOne(id);
    }
}
