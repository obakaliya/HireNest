package com.server.dto.requests;

import lombok.Getter;

@Getter
public class RegisterRequest {
  private String email;
  private String firstName;
  private String lastName;
  private String password;
  private String role;
}
