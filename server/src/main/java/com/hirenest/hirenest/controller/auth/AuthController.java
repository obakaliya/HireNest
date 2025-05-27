package com.hirenest.hirenest.controller.auth;

import com.hirenest.hirenest.dto.requests.AuthRequest;
import com.hirenest.hirenest.dto.requests.RegisterRequest;
import com.hirenest.hirenest.dto.responses.AuthResponse;
import com.hirenest.hirenest.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
    return ResponseEntity.ok(authService.authenticate(request));
  }

  @PostMapping("/register")
  public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }
}
