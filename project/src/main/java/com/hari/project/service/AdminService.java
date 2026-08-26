package com.hari.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hari.project.dto.UserResponse;
import com.hari.project.entity.Users;
import com.hari.project.enums.Role;
import com.hari.project.repo.UserRepository;

@Service
public class AdminService {

    private UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole().name(),
                        user.getStatus().name()))
                .toList();
    }

    public long getTotalUsers() {
        return userRepository.count();
    }
    
    public String makeEmployee(Long id) {

        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(Role.ADMIN);

        userRepository.save(user);

        return "Employee created successfully";
    }

    public String makeAdmin(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(Role.ADMIN);
        userRepository.save(user);

        return "User is now ADMIN";
    }
    
    public List<UserResponse> getCustomers() {

        return userRepository.findByRole(Role.USER)
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole().name(),
                        user.getStatus().name()
                ))
                .toList();
    }
}
