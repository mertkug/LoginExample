package com.loginexample.controller;

import com.loginexample.models.ApplicationUser;
import com.loginexample.dto.LoginResponseDTO;
import com.loginexample.dto.RegistrationDTO;
import com.loginexample.services.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService auth;


    public AuthenticationController(AuthenticationService auth) {
        this.auth = auth;
    }

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
        return auth.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return auth.loginUser(body.getUsername(), body.getPassword());
    }
}
