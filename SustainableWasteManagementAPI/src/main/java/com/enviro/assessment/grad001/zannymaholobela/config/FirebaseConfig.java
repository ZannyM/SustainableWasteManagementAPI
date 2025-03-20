package com.enviro.assessment.grad001.zannymaholobela.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class FirebaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        logger.info("Initializing Firebase application");

        // Check if Firebase is already initialized to avoid multiple initializations
        if (FirebaseApp.getApps().isEmpty()) {
            try {
                // Try to load the service account file
                GoogleCredentials credentials = GoogleCredentials
                        .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(credentials)
                        .build();

                return FirebaseApp.initializeApp(options);
            } catch (IOException e) {
                logger.error("Could not initialize Firebase with service account file: {}", e.getMessage());

                // For development, allow continuing without Firebase
                logger.warn("Creating a default Firebase configuration without authentication for development");
                FirebaseOptions options = FirebaseOptions.builder()
                        .setProjectId("sustainable-waste-management")
                        .setCredentials(GoogleCredentials.getApplicationDefault()) // This will use ADC if available
                        .build();

                return FirebaseApp.initializeApp(options);
            }
        }

        logger.info("Firebase application already initialized");
        return FirebaseApp.getInstance();
    }
}