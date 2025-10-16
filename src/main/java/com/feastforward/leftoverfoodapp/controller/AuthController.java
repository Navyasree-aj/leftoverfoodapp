package com.feastforward.leftoverfoodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.feastforward.leftoverfoodapp.model.User;
import com.feastforward.leftoverfoodapp.repository.UserRepository;

import java.util.Map;  // <- IMPORTANT import

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://127.0.0.1:5500") 
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // --- Register a new user ---
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    // --- Login check ---
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) { // <-- changed return type
        return userRepository.findByEmail(user.getEmail())
                .map(existingUser -> {
                    if (!existingUser.getPassword().equals(user.getPassword())) {
                        Map<String, String> response = Map.of("message", "Invalid password");
                        return ResponseEntity.badRequest().body(response);
                    }
                    Map<String, String> response = Map.of(
                            "message", "Login successful",
                            "role", existingUser.getRole()
                    );
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Map<String, String> response = Map.of("message", "User not found");
                    return ResponseEntity.badRequest().body(response);
                });
    }
}
