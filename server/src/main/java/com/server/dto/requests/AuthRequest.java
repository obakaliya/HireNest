package com.server.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthRequest {
  @NotBlank @Email private String email;
  @NotBlank private String password;
}
