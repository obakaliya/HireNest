package com.server.dto.responses;

import com.server.entity.Role;
import com.server.entity.User;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthUserResponse {
  private String firstName;
  private String lastName;
  private String email;
  private Set<Role> roles;

  public static AuthUserResponse toAuthUser(User user) {
    return new AuthUserResponse(
        user.getFirstName(), user.getLastName(), user.getEmail(), user.getRoles());
  }
}
