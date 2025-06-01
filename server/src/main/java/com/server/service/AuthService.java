package com.server.service;

import com.server.dto.requests.AuthRequest;
import com.server.dto.requests.RegisterRequest;
import com.server.dto.responses.AuthResponse;

public interface AuthService {
  public AuthResponse authenticate(AuthRequest request);

  public AuthResponse register(RegisterRequest request);
}
