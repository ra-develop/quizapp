package com.example.quizapp.model;


import jakarta.validation.constraints.*;

public class User {
    
    @NotBlank(message = "User name is required")
    @Size(min = 3)
    private String username;
    
    @NotBlank(message = "Password is required")
    @Size(min = 6)
    private String password;

    @NotBlank(message = "Role is required")    
    private String role; // Add a role field

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    public User(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
