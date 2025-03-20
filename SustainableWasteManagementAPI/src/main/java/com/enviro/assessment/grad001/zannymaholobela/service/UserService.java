package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.dto.UserRegistrationRequest;
import com.enviro.assessment.grad001.zannymaholobela.dto.UserRegistrationResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        try {
            // Validate user input
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new IllegalArgumentException("Email is required");
            }
            if (request.getPassword() == null || request.getPassword().length() < 6) {
                throw new IllegalArgumentException("Password must be at least 6 characters");
            }

            // Create user in Firebase
            UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest()
                    .setEmail(request.getEmail())
                    .setPassword(request.getPassword())
                    .setDisplayName(request.getDisplayName() != null ? request.getDisplayName() : "")
                    .setDisabled(false);

            UserRecord userRecord = FirebaseAuth.getInstance().createUser(createRequest);

            // Set custom claims for role-based access control
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", "USER"); // Default role
            FirebaseAuth.getInstance().setCustomUserClaims(userRecord.getUid(), claims);

            logger.info("Successfully registered user with email: {}", request.getEmail());

            return new UserRegistrationResponse(userRecord.getUid(), userRecord.getEmail(),
                    "User registered successfully");
        } catch (FirebaseAuthException e) {
            logger.error("Firebase authentication error: {}", e.getMessage());
            throw new RuntimeException("Error registering user: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            throw e;
        }
    }

    public void setUserRole(String uid, String role) throws FirebaseAuthException {
        if (uid == null || uid.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role is required");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role.toUpperCase());
        FirebaseAuth.getInstance().setCustomUserClaims(uid, claims);

        logger.info("Updated role to {} for user {}", role.toUpperCase(), uid);
    }
}