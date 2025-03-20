package com.enviro.assessment.grad001.zannymaholobela.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirebaseAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(FirebaseAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            String uid = decodedToken.getUid();

            logger.debug("Firebase Authentication successful for user: {}", uid);

            // Extract user roles from custom claims
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();

            // Check for role in custom claims
            if (decodedToken.getClaims().containsKey("role")) {
                String role = decodedToken.getClaims().get("role").toString();
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
                logger.debug("Added role {} for user {}", role.toUpperCase(), uid);
            } else {
                // Default role if none specified
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                logger.debug("Added default ROLE_USER for user {}", uid);
            }

            // Create authentication token
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    uid, null, authorities);

            // Set authentication in context
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (FirebaseAuthException e) {
            logger.error("Firebase Authentication failed: {}", e.getMessage());
            // Do not set authentication - user will be treated as unauthenticated
        }

        filterChain.doFilter(request, response);
    }
}


