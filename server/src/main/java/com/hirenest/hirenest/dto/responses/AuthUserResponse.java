package com.hirenest.hirenest.dto.responses;

import com.hirenest.hirenest.entitiy.Role;
import com.hirenest.hirenest.entitiy.User;

public class AuthUserResponse {
  private String firstName;
  private String lastName;
  private String email;
  private Role role;

  public AuthUserResponse(String firstName, String lastName, String email, Role role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.role = role;
  }

  public static AuthUserResponse fromUser(User user) {
    return new AuthUserResponse(
        user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public Role getRole() {
    return role;
  }
}
