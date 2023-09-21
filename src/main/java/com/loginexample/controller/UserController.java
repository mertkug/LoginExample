package com.loginexample.controller;

import com.loginexample.annotations.CurrentUser;
import com.loginexample.models.ApplicationUser;
import com.loginexample.models.Post;
import com.loginexample.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    private final PostService postService;

    public UserController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String helloUserController(){
        return "User access level";
    }

    @GetMapping("/my-posts")
    public Set<Post> myPosts(@CurrentUser ApplicationUser user) {
        return postService.getPostsByOwner(user.getId());
    }
}