package com.hari.project.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hari.project.dto.LoginRequest;
import com.hari.project.dto.LoginResponse;
import com.hari.project.dto.RegisterRequest;
import com.hari.project.entity.Users;
import com.hari.project.enums.Role;
import com.hari.project.enums.UserStatus;
import com.hari.project.repo.UserRepository;
import com.hari.project.security.JwtService;

@Service
public class AuthService {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public AuthService(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String userRegistration(RegisterRequest request) {

        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            return "user Exist";
        }

        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            return "email Exist";
        }

        Users newUser = new Users();
        newUser.setEmail(request.getEmail());
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(Role.USER);
        newUser.setStatus(UserStatus.ACTIVE);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        userRepo.save(newUser);
        return "user added";
    }

    public LoginResponse userLogin(LoginRequest loginReq) {

        Optional<Users> byUsername = userRepo.findByUsername(loginReq.getUsername());

        if (byUsername.isPresent()) {
            Users user = byUsername.get();

            if (user.getStatus() == UserStatus.ACTIVE
                    && passwordEncoder.matches(loginReq.getPassword(), user.getPassword())) {

                String token = jwtService.generateToken(
                        user.getUsername(), user.getRole().name());

                return new LoginResponse(
                        user.getUsername(),
                        user.getRole().name(),
                        token);
            }
        }

        throw new RuntimeException("Invalid username or password");
    }

    public void createDefaultAdmin() {

        Optional<Users> admin = userRepo.findByUsername("admin");
        Users newAdmin;

        if (admin.isPresent()) {
            newAdmin = admin.get();
        } else {
            newAdmin = new Users();
            newAdmin.setUsername("admin");
            newAdmin.setCreatedAt(LocalDateTime.now());
        }

        newAdmin.setEmail("admin@gmail.com");
        newAdmin.setPassword(passwordEncoder.encode("admin@123"));
        newAdmin.setRole(Role.ADMIN);
        newAdmin.setStatus(UserStatus.ACTIVE);
        newAdmin.setUpdatedAt(LocalDateTime.now());

        userRepo.save(newAdmin);
    }
}
