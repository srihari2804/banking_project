package com.hari.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hari.project.entity.Users;
import com.hari.project.repo.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));
    }

    public List<Users> getAllUsers() {

        return userRepository.findAll();
    }
}