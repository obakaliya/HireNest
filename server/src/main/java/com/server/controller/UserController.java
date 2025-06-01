package com.server.controller;

import com.server.dto.responses.AuthUserResponse;
import com.server.entity.User;
import com.server.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;

  @GetMapping("/auth")
  public ResponseEntity<AuthUserResponse> getAuthUser(@Valid @AuthenticationPrincipal User user) {
    return ResponseEntity.ok(AuthUserResponse.toAuthUser(user));
  }
}
