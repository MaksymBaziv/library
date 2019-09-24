package com.max.controller.user;

import com.max.dao.UserDAO;
import com.max.model.User;
import com.max.model.dto.UserSessionDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    UserDAO userDAO = UserDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserSessionDTO loginedUser = (UserSessionDTO) request.getSession().getAttribute("loginedUser");
        User user = userDAO.findUserByEmail(loginedUser.getEmail());
        request.setAttribute("user", user);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
