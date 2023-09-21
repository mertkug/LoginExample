package com.logintry.controller;

import com.logintry.annotations.CurrentUser;
import com.logintry.dto.PostCreateDTO;
import com.logintry.models.ApplicationUser;
import com.logintry.models.Post;
import com.logintry.services.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
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
        Post post = new Post(user, postReq.getText());
        user.addPost(post);
        postService.createPost(post);
    }

    @GetMapping("/get-post/{id}")
    public Post getPostById(@PathVariable("id") Post post) {
        return postService.getPost(post);
    }
}
