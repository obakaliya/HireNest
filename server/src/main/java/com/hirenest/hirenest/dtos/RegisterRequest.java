package com.hirenest.hirenest.dtos;

public class RegisterRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
