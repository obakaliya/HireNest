package com.server.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthRequest {
  @NotBlank private String email;
  @NotBlank private String password;
}
