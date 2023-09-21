package com.logintry.controller;

import com.logintry.dto.PostCreateDTO;
import com.logintry.models.Post;
import com.logintry.services.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create-post")
    public void createPost(@RequestBody PostCreateDTO post){
        postService.createPost(new Post(post.getText()));
    }

    @GetMapping("/get-post/{id}")
    public Post getPostById(@PathVariable("id") Post post) {
        return postService.getPost(post);
    }
}
