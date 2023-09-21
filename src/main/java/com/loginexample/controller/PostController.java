package com.loginexample.controller;

import com.loginexample.annotations.CurrentUser;
import com.loginexample.dto.PostCreateDTO;
import com.loginexample.models.ApplicationUser;
import com.loginexample.models.Post;
import com.loginexample.services.PostService;
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
    public void createPost(@RequestBody PostCreateDTO postReq, @CurrentUser ApplicationUser user){
        Post post = new Post(user, postReq.getText(), 0);
        user.addPost(post);
        postService.createPost(post);
    }

    @GetMapping("/get-post/{id}")
    public Post getPostById(@PathVariable("id") Post post) {
        return postService.getPost(post);
    }
}
