package com.max.model.dto;

import com.max.dao.UserDAO;
import com.max.model.User;

public class UserSessionDTO {

    private static UserSessionDTO userSessionDTO = null;
    Long id;
    String email;
    String userRole;

    public static UserSessionDTO getInstance() {
        if (userSessionDTO == null)
            userSessionDTO = new UserSessionDTO();

        return userSessionDTO;
    }

    public static UserSessionDTO fromUser(User user) {
        final UserSessionDTO result = new UserSessionDTO();
        result.setId(user.getId());
        result.setEmail(user.getEmail());
        result.setUserRole(user.getUserRole());
        return result;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
