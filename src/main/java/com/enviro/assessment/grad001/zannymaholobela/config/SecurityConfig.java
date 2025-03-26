// src/main/java/com/enviro/assessment/grad001/zannymaholobela/config/SecurityConfig.java
package com.enviro.assessment.grad001.zannymaholobela.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth -> auth
//                        // Allow access to static resources and Swagger
//                        .requestMatchers("/", "/index.html", "/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
//                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
//                        // Public endpoints - allow read access to waste categories, tips, and guidelines
//                        .requestMatchers(HttpMethod.GET, "/api/waste-categories/**", "/api/recycling-tips/**", "/api/disposal-guidelines/**").permitAll()
//                        // Admin endpoints - require ADMIN role
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                        // All other write operations require authentication
//                        .requestMatchers(HttpMethod.POST, "/api/**").authenticated()
//                        .requestMatchers(HttpMethod.PUT, "/api/**").authenticated()
//                        .requestMatchers(HttpMethod.DELETE, "/api/**").authenticated()
//                        // Default policy for anything else
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(httpBasic -> {});
//
//        return http.build();
//    }
}