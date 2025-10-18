package com.feastforward.leftoverfoodapp.controller;

import com.feastforward.leftoverfoodapp.model.User;
import com.feastforward.leftoverfoodapp.repository.UserRepository;
import com.feastforward.leftoverfoodapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // --- Register a new user ---
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(Map.of(
                    "message", "User registered successfully",
                    "role", savedUser.getRole()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    // --- Login check ---
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
        return userRepository.findByEmail(user.getEmail())
                .map(existingUser -> {
                    // Compare password using BCrypt
                    if (!new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
                            .matches(user.getPassword(), existingUser.getPassword())) {
                        return ResponseEntity.badRequest().body(Map.of("message", "Invalid password"));
                    }

                    return ResponseEntity.ok(Map.of(
                            "message", "Login successful",
                            "role", existingUser.getRole()
                    ));
                })
                .orElseGet(() -> ResponseEntity.badRequest().body(Map.of("message", "User not found")));
    }
}
