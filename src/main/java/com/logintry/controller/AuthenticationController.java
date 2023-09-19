package com.logintry.controller;

import com.logintry.models.ApplicationUser;
import com.logintry.models.RegistrationDTO;
import com.logintry.services.AuthenticationService;
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
        System.out.print("hi");
        return auth.registerUser(body.getUsername(), body.getPassword());
    }
}
