package com.server.service.impl;

import com.server.constants.ROLES;
import com.server.dto.requests.AuthRequest;
import com.server.dto.requests.RegisterRequest;
import com.server.dto.responses.AuthResponse;
import com.server.entity.Role;
import com.server.entity.User;
import com.server.exception.BadRequestException;
import com.server.exception.ResourceNotFoundException;
import com.server.repository.RoleRepository;
import com.server.repository.UserRepository;
import com.server.security.JwtTokenProvider;
import com.server.service.AuthService;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtTokenProvider jwtTokenProvider;

  @Override
  public AuthResponse authenticate(AuthRequest request) {
    userRepository
        .findByEmail(request.getEmail())
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    String token =
        jwtTokenProvider.generateToken(
            (org.springframework.security.core.userdetails.UserDetails)
                authentication.getPrincipal());

    return new AuthResponse(token);
  }

  @Override
  public AuthResponse register(RegisterRequest request) {
    Role role =
        roleRepository
            .findByName(ROLES.JOB_SEEKER)
            .orElseThrow(() -> new BadRequestException("Invalid role"));

    Set<Role> roles = new HashSet<>();
    roles.add(role);

    User user = new User();
    user.setEmail(request.getEmail());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setRoles(roles);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    userRepository.save(user);

    String token = jwtTokenProvider.generateToken(user);
    return new AuthResponse(token);
  }
}
