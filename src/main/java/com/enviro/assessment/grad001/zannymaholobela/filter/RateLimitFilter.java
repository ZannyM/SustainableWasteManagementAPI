package com.enviro.assessment.grad001.zannymaholobela.filter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RateLimitFilter.class);

    // Map to store rate limiters for different clients (IP addresses)
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Skip rate limiting for GET requests to enhance performance for read operations
        if (request.getMethod().equals("GET")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get client IP address
        String clientIp = getClientIP(request);

        // Get or create bucket for this client
        Bucket bucket = buckets.computeIfAbsent(clientIp, this::createNewBucket);

        // Try to consume a token
        if (bucket.tryConsume(1)) {
            filterChain.doFilter(request, response);
        } else {
            // If no tokens are available, return 429 Too Many Requests
            logger.warn("Rate limit exceeded for IP: {}", clientIp);
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Too many requests. Please try again later.\",\"status\":429}");
        }
    }

    private Bucket createNewBucket(String clientIp) {
        // Allow 50 write requests per minute
        Bandwidth limit = Bandwidth.classic(50, Refill.greedy(50, Duration.ofMinutes(1)));
        logger.debug("Created new rate limit bucket for IP: {}", clientIp);
        return Bucket.builder().addLimit(limit).build();
    }

    private String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}