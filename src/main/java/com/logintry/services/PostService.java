package com.logintry.services;

import com.logintry.models.Post;
import com.logintry.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public Post getPost(Post post) {
        return post;
    }
}
