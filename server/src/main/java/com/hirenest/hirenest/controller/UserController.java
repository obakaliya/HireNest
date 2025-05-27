package com.hirenest.hirenest.controller;

import com.hirenest.hirenest.dto.responses.AuthUserResponse;
import com.hirenest.hirenest.entitiy.User;
import com.hirenest.hirenest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    if (userDetails == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    User user = userService.authUser(userDetails.getUsername());
    return ResponseEntity.ok(AuthUserResponse.fromUser(user));
  }
}
