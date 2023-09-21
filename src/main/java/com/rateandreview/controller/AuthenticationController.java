package com.rateandreview.controller;

import com.rateandreview.models.ApplicationUser;
import com.rateandreview.dto.LoginResponseDTO;
import com.rateandreview.dto.RegistrationDTO;
import com.rateandreview.services.AuthenticationService;
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
