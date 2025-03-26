package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.dto.UserRegistrationRequest;
import com.enviro.assessment.grad001.zannymaholobela.dto.UserRegistrationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        try {
            // Validate user input
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new IllegalArgumentException("Email is required");
            }
            if (request.getPassword() == null || request.getPassword().length() < 6) {
                throw new IllegalArgumentException("Password must be at least 6 characters");
            }

            // In a real application, you would store the user in a database
            // For now, we're just returning a response (users are configured in SecurityConfig)
            logger.info("Successfully registered user with email: {}", request.getEmail());

            return new UserRegistrationResponse("user-id", request.getEmail(),
                    "User registered successfully (Note: In-memory authentication is used, so this user won't persist)");

        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            throw e;
        }
    }

    // check if a user exists
    public boolean userExists(String username) {
        try {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            return user != null;
        } catch (Exception e) {
            return false;
        }
    }
}