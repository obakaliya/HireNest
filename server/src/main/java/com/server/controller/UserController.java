package com.server.controller;

import com.server.dto.responses.AuthUserResponse;
import com.server.entitiy.User;
import com.server.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;

  @GetMapping("/auth")
  public ResponseEntity<AuthUserResponse> getAuthUser(
      @AuthenticationPrincipal UserDetails userDetails) {
    User user = userService.authUser(userDetails.getUsername());
    return ResponseEntity.ok(AuthUserResponse.fromUser(user));
  }
}
