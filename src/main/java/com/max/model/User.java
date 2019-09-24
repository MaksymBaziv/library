package com.max.model;

public class User {
    Long id;
    String email;
    String password;
    String zipCode;
    String userRole;

    public User() {
    }

    public User(Long id, String email, String password, String zipCode) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
