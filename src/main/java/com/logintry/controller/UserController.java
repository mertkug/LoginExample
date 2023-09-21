package com.logintry.controller;

import com.logintry.dto.PostCreateDTO;
import com.logintry.models.Post;
import com.logintry.services.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @GetMapping("/")
    public String helloUserController(){
        return "User access level";
    }
}