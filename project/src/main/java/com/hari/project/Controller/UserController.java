package com.hari.project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.project.entity.Users;
import com.hari.project.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping
    public List<Users> getAllUsers() {

        return userService.getAllUsers();
    }
}