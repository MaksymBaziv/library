package com.max.controller.user;

import com.max.controller.BaseServlet;
import com.max.dao.UserDAO;
import com.max.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet("/register")
public class RegistrationServlet extends BaseServlet {

    UserDAO userDAO = UserDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String repeatPassword = request.getParameter("RepeatPassword");
        String zipCode = request.getParameter("zipCode");
        User registrationDTO = new User();
        registrationDTO.setEmail(email);
        registrationDTO.setPassword(password);
        registrationDTO.setZipCode(zipCode);
        User user = userDAO.findUserByEmail(email);
        if (user != null && email.equals(user.getEmail())) {
            request.getRequestDispatcher("/registration.jsp?error=email").forward(request, response);
        } else if (!password.equals(repeatPassword)) {
            request.getRequestDispatcher("/registration.jsp?error=password").forward(request, response);
        } else {
            userDAO.save(registrationDTO);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
