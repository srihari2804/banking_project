package com.hari.project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.project.dto.UserResponse;
import com.hari.project.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PutMapping("/users/{id}/change-admin")
    public String changeAdmin(@PathVariable Long id) {
        return adminService.makeAdmin(id);
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Total Users: " + adminService.getTotalUsers();
    }

    @GetMapping("/customers")
    public List<UserResponse> getCustomers() {
        return adminService.getCustomers();
    }
}