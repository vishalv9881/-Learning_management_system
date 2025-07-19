package com.example.student_mangement.controller;

import com.example.student_mangement.dto.AuthRequest;
import com.example.student_mangement.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager; // ✅ Now this will work

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        logger.info("Login attempt for user: {}", authRequest.getEmail());

        try {
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );

            // Generate JWT token
            String token = jwtUtil.generateToken(authRequest.getEmail());

            logger.info("Login successful for user: {}", authRequest.getEmail());

            return ResponseEntity.ok(new AuthRequest(token, "Login successful"));

        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user: {}", authRequest.getEmail(), e);
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}