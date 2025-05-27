package com.hirenest.hirenest.service;

import com.hirenest.hirenest.dto.requests.AuthRequest;
import com.hirenest.hirenest.dto.requests.RegisterRequest;
import com.hirenest.hirenest.dto.responses.AuthResponse;
import com.hirenest.hirenest.entitiy.Role;
import com.hirenest.hirenest.entitiy.User;
import com.hirenest.hirenest.repository.RoleRepository;
import com.hirenest.hirenest.repository.UserRepository;
import com.hirenest.hirenest.security.JwtTokenProvider;
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
