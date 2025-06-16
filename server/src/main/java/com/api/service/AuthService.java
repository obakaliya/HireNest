package com.api.service;

import com.api.dto.requests.AuthRequest;
import com.api.dto.requests.RegisterRequest;
import com.api.dto.responses.AuthResponse;

public interface AuthService {
  AuthResponse authenticate(AuthRequest request);

  AuthResponse register(RegisterRequest request);
}
