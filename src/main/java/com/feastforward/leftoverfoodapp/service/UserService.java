package com.feastforward.leftoverfoodapp.service;

import com.feastforward.leftoverfoodapp.model.User;
import com.feastforward.leftoverfoodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(String username, String email, String password) {
        // Optionally, check if username or email already exists
        if(userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already taken");
        }
        if(userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Hash password
        user.setRole("USER");

        return userRepository.save(user);
    }
}
