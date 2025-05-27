package com.server.service;

import com.server.constants.ROLES;
import com.server.dto.requests.AuthRequest;
import com.server.dto.requests.RegisterRequest;
import com.server.dto.responses.AuthResponse;
import com.server.entitiy.Role;
import com.server.entitiy.User;
import com.server.repository.RoleRepository;
import com.server.repository.UserRepository;
import com.server.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtTokenProvider jwtTokenProvider;

  public AuthResponse authenticate(AuthRequest request) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    String token =
        jwtTokenProvider.generateToken(
            (org.springframework.security.core.userdetails.UserDetails)
                authentication.getPrincipal());
    return new AuthResponse(token);
  }

  public AuthResponse register(RegisterRequest request) {
    if (ROLES.SUPERUSER.equalsIgnoreCase(request.getRole()))
      throw new IllegalArgumentException("You are not allowed to register as a superuser.");

    Role role = roleRepository.findByName(request.getRole()).orElseThrow();

    User user = new User();
    user.setEmail(request.getEmail());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setRole(role);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    userRepository.save(user);

    String token =
        jwtTokenProvider.generateToken(
            new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), java.util.Collections.emptyList()));
    return new AuthResponse(token);
  }
}
