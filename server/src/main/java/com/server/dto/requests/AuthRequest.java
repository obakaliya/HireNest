package com.server.dto.requests;

import lombok.Getter;

@Getter
public class AuthRequest {
  private String email;
  private String password;
}
