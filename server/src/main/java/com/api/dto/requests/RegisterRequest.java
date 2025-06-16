package com.api.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RegisterRequest {
  @NotBlank @Email private String email;
  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @NotBlank private String password;
}
