package com.api.service.impl;

import com.api.dto.responses.AuthUserResponse;
import com.api.entity.User;
import com.api.exception.ResourceNotFoundException;
import com.api.repository.UserRepository;
import com.api.service.UserService;
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

  @Override
  public AuthUserResponse authUser() {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return AuthUserResponse.toAuthUser(user);
  }
}
