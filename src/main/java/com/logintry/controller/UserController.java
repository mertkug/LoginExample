package com.logintry.controller;

import com.logintry.annotations.CurrentUser;
import com.logintry.dto.PostCreateDTO;
import com.logintry.models.ApplicationUser;
import com.logintry.models.Post;
import com.logintry.repository.PostRepository;
import com.logintry.services.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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