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

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String, Boolean> userActiveStatus = new HashMap<>();

    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        try {
            // Validate user input
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new IllegalArgumentException("Email is required");
            }
            if (request.getPassword() == null || request.getPassword().length() < 6) {
                throw new IllegalArgumentException("Password must be at least 6 characters");
            }

            String userId = "user-" + System.currentTimeMillis();
            userActiveStatus.put(userId, true);

            logger.info("Successfully registered user with email: {}", request.getEmail());

            return new UserRegistrationResponse(userId, request.getEmail(),
                    "User registered successfully");

        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            throw e;
        }
    }

    // Simulate deactivating a user (soft delete)
    public void deactivateUser(String userId) {
        if (userActiveStatus.containsKey(userId)) {
            userActiveStatus.put(userId, false);
            logger.info("User deactivated: {}", userId);
        } else {
            throw new RuntimeException("User not found: " + userId);
        }
    }

    // reactivating a user
    //simulating
    public void reactivateUser(String userId) {
        if (userActiveStatus.containsKey(userId)) {
            userActiveStatus.put(userId, true);
            logger.info("User reactivated: {}", userId);
        } else {
            throw new RuntimeException("User not found: " + userId);
        }
    }

    // Check if a user is active
    public boolean isUserActive(String userId) {
        return userActiveStatus.getOrDefault(userId, false);
    }

    // Check if a user exists by username
    public boolean userExists(String username) {
        try {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            return user != null;
        } catch (Exception e) {
            return false;
        }
    }
}