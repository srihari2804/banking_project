package com.hari.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hari.project.service.AuthService;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    } 

    @Bean
    CommandLineRunner createAdmin(AuthService authService) {
        return args -> authService.createDefaultAdmin();
    }
} 
