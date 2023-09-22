package com.rateandreview.controller;

import com.rateandreview.annotations.CurrentUser;
import com.rateandreview.dto.PostCreateDTO;
import com.rateandreview.models.ApplicationUser;
import com.rateandreview.models.Post;
import com.rateandreview.services.PostService;
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

    @PostMapping("/like-post/{id}")
    public void likePostById(@PathVariable("id") Post post) {
        postService.likePost(post);
    }
}
