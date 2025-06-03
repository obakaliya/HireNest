package com.server.service;

import com.server.dto.requests.AuthRequest;
import com.server.dto.requests.RegisterRequest;
import com.server.dto.responses.AuthResponse;

public interface AuthService {
  AuthResponse authenticate(AuthRequest request);

  AuthResponse register(RegisterRequest request);
}
