package com.hari.project.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.project.dto.LoginRequest;
import com.hari.project.dto.LoginResponse;
import com.hari.project.dto.RegisterRequest;
import com.hari.project.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String registerData(@RequestBody RegisterRequest register) {
        return authService.userRegistration(register);
    }

    @PostMapping("/login")
    public LoginResponse loginData(@RequestBody LoginRequest login) {
        return authService.userLogin(login);
    }
}
