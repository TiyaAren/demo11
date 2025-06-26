package com.example.demo.controllers;

import com.example.demo.DTO.RegisterRequest;
import com.example.demo.services.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/reqister")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest);
        return ResponseEntity.ok("Register was successfully");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody Authentication authentication) {
        return ResponseEntity.ok("Login was successfully " + authentication.getName());
    }
}
