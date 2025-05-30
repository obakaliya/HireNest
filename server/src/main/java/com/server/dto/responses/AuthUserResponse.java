package com.server.dto.responses;

import com.server.entitiy.Role;
import com.server.entitiy.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthUserResponse {
  private String firstName;
  private String lastName;
  private String email;
  private Role role;

  public static AuthUserResponse toAuthUser(User user) {
    return new AuthUserResponse(
        user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
  }
}
