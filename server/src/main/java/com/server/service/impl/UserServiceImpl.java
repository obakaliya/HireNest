package com.server.service.impl;

import com.server.dto.responses.AuthUserResponse;
import com.server.entity.User;
import com.server.exception.ResourceNotFoundException;
import com.server.repository.UserRepository;
import com.server.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository
        .findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
  }

  public AuthUserResponse authUser() {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return new AuthUserResponse(
        user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
  }
}
