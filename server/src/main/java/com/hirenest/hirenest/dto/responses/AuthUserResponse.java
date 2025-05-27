package com.hirenest.hirenest.dto.responses;

import com.hirenest.hirenest.entitiy.Role;
import com.hirenest.hirenest.entitiy.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthUserResponse {
  private String firstName;
  private String lastName;
  private String email;
  private Role role;

  public static AuthUserResponse fromUser(User user) {
    return new AuthUserResponse(
        user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
  }
}
